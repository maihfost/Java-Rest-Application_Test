$(document).ready(function () {
    
    var myUrl = "http://localhost:8080/api/company/all";
    $.ajax({ url: myUrl }).then(
        function (companies) {
          $.each(companies, function (i, company) {
            var company_option = "<option value='" + company.id + "'>" + company.name + "</option>";
            $("#companies").append(company_option);

          });
    });

    $("#save").click(function () {
        var name=$("#name").val();
        var email=$("#email").val();
        var companyId= parseInt($("#companies").val());
        var myUrl2 = "http://localhost:8080/api/user/new";
        $.ajax(
            {   
                type: "POST",
                url: myUrl2,
                headers: {
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify({
                    name: name,
                    email: email,
                    companyId: companyId
                })
            });
            alert("User Successfully Inserted!");
            window.location.href = 'index.html';
    });
    

   


});