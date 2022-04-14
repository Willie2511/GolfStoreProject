var rootUrl="http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest";



getAllOrders = function() {
    console.log("working");
    $.ajax({
        type:'GET',
        url:rootUrl + "/Orders",
        dataType:'json',
        success:

            renderList

    });
}

renderList = function(list) {
    console.log(list)
    htmlStr = '';
    $.each(list, function(index, product) {
        htmlStr += '<div id= "'+product.orderId+'" class="column">';
        htmlStr += '<div class="card">';
        htmlStr += '<p style="font-size:20px; color:white;">'+"Order Id: "+ product.orderId+ '</p>';
        htmlStr += '<p style="font-size:20px; color:white;">'+"Product Id: "+ product.productId+ '</p>';
        htmlStr += '<p style="font-size:20px; color:white;">'+ product.status+ '</p>';
        htmlStr += '<p style="font-size:20px; color:white;">'+"Total Price: €"+ product.totalPrice+ '</p>';
        htmlStr += '</div>';
        htmlStr += '</div>';
    });
    $('#myDiv').append(htmlStr);
};


$(document).ready(function(){



getAllOrders()



});