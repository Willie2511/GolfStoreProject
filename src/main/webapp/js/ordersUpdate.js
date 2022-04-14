var rootUrl="http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest";

updateOrders = function(orderNumber, status) {
    console.log(orderNumber);
    console.log(status);
    $.ajax({
        type: 'PUT',
        url: rootUrl + "/Orders/update/"+orderNumber+"/"+status,
        dataType: 'json',
        contentType: "application/json",
        data: JSON,
        success:
            window.location.href="StaffCRUD.html",

        error:
            console.log("error")
    })
}


$(document).ready(function(){

    console.log(document.getElementById("status").value);




});
