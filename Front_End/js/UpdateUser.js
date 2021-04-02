$(document).ready(function () {
    
    var myUrl = "http://localhost:8080/api/user/all";
    $.ajax({ url: myUrl }).then(
        function (users) {
          $.each(users, function (i, user) {
            var user_option = "<option value='" + user.id + "'>" + user.name + "</option>";
            $("#users").append(user_option);
          });
    });


    $("#users").on("change", function () {
        var id = this.value;
        var myUrl = "http://localhost:8080/api/user/id/" + id ;
        $.ajax({
            type: "GET",
            url: myUrl,
            dataType: "json",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS, UPDATE",
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function (response) {
                $("#name").val(response.name);
                $("#email").val(response.email);
            }
        });
    });

    $("#save").click(function(){
        var myUrl2 = "http://localhost:8080/api/user/update";
        var id = $("#users").val();
        var name = $("#name").val();
        var email = $("#email").val();
        $.ajax(
            {
              type: "PUT",
              url: myUrl2,
              dataType: "json",
              headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
              },
              data: JSON.stringify({
                id: id,
                name: name,
                email: email
              })
            });
            alert("Updated");
            window.location.href = 'index.html';
    });

});