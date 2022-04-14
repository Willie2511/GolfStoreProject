
var rootUrl="http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest";






var findAll=function(){
	$.ajax({type:'GET',
        url:rootUrl + "/Products/search/Driver",
        dataType:'json',
        success:
        	renderList
        
});
}



var renderList = function(list) {
	console.log(list)
	htmlStr = '';
	$('.details').remove();
	$.each(list, function(index, drivers) {
		htmlStr += '<div id= "'+drivers.productId+'" class="column">';
		console.log(drivers.productId);
		htmlStr += '<div class="card">';
		htmlStr += '<img src="img/products/'+drivers.image+'" height="200px" width="200px">';
		htmlStr += '<p style="font-size:20px; color:white;">'+ drivers.make+ '</p>';
		htmlStr += '<p style="font-size:20px; color:white;">'+ drivers.model+ '</p>';
		htmlStr += '<p style="font-size:20px; color:white;">€ '+ drivers.price+ '</p>';
		htmlStr += '<li class="infoButton"><a href="" class="button2" onclick="addToCart('+drivers.productId+') ; addCartPrice('+drivers.price+');"> Add To Cart </a></li>'
		htmlStr += '</div>';
		htmlStr += '</div>';
			
	});
	$('#driverList').append(htmlStr);

};


$(document).ready(function(){   



findAll();

document.getElementById("cartCount").innerHTML = getCartCount();

});