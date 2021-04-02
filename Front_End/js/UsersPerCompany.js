$(document).ready(function () {
    
    var myUrl = "http://localhost:8080/api/company/all";
    $.ajax({ url: myUrl }).then(
        function (companies) {
          $.each(companies, function (i, company) {
            var company_option = "<option value='" + company.id + "'>" + company.name + "</option>";
            $("#companies").append(company_option);

          });
    });

    $("#companies").change(function(){
        $("td").remove();
        var idd = parseInt(this.value);
        var myUrl = "http://localhost:8080/api/user/company/id/"+ idd;

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
                    </tr>')
            });
        });
    });
    
});