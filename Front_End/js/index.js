$(document).ready(function () {

    var myUrl = "http://localhost:8080/api/user/all";

    $.ajax(
        {
            url: myUrl 
        }).then(function (users) {
          $.each(users, function (i,user) {

            $(".users").append('\
                <tr >\
                    <td id="user_id">' + user.id + '</td>\
                    <td id="user_name">' + user.name + '</td>\
                    <td id="user_email">' + user.email + '</td>\
                    <td>\
                        <button type="button" class="delete" id="de_'+ user.id +'">Delete</button>\
                    </td>\
                </tr>')
          });
        });

        $("body").on("click", ".delete", function () {
            var idd = parseInt(this.id.toString().slice(3));
            var url2 = "http://localhost:8080/api/user/delete";
            $.ajax(
                {
                  type: "DELETE",
                  url: url2,
                  dataType: "json",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  data: JSON.stringify({
                      id: idd
                  })
                });
            alert("User deleted successfully!");
            window.location.reload();
        });

    


});