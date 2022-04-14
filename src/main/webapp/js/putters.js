

var rootUrl="http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest";



var findAll=function(){
	$.ajax({type:'GET',
        url:rootUrl + "/Products/search/Putters",
        dataType:'json',
        success:
        	renderList
        
});
}



var renderList = function(list) {
	console.log(list)
	htmlStr = '';
	$('.details').remove();
	$.each(list, function(index, putters) {
		htmlStr += '<div id= "'+putters.productId+'" class="column">';
		htmlStr += '<div class="card">';
		htmlStr += '<img src="img/products/'+putters.image+'" height="200px" width="200px">';
		htmlStr += '<p style="font-size:20px; color:white;">'+ putters.make+ '</p>';
		htmlStr += '<p style="font-size:20px; color:white;">'+ putters.model+ '</p>';
		htmlStr += '<p style="font-size:20px; color:white;">€ '+ putters.price+ '</p>';
		htmlStr += '<li class="infoButton"><a href="" class="button2" onclick="addToCart('+putters.productId+') ; addCartPrice('+putters.price+');"> Add To Cart </a></li>'
		htmlStr += '</div>';
		htmlStr += '</div>';
	});
	$('#putterList').append(htmlStr);
};


$(document).ready(function(){   
	

	
findAll();

	document.getElementById("cartCount").innerHTML = getCartCount();

});