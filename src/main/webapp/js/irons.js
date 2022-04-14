var rootUrl="http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest";



var findAll=function(){
	$.ajax({type:'GET',
        url:rootUrl + "/Products/search/Irons",
        dataType:'json',
        success:
        	renderList
        
});
}

var renderList = function(list) {
	console.log(list)
	htmlStr = '';
	$('.details').remove();
	$.each(list, function(index, product) {
		console.log(product.model);
		htmlStr += '<div id= "'+product.productId+'" class="column">';
		htmlStr += '<div class="card">';
		htmlStr += '<img src="img/products/'+product.image+'" height="200px" width="200px">';
		htmlStr += '<p style="font-size:20px; color:white;">'+ product.make+ '</p>';
		htmlStr += '<p style="font-size:20px; color:white;">'+ product.model+ '</p>';
		htmlStr += '<p style="font-size:20px; color:white;">€ '+ product.price+ '</p>';
		htmlStr += '<li class="infoButton"><a href="" class="button2" onclick="addToCart('+product.productId+') ; addCartPrice('+product.price+');"> Add To Cart </a></li>'
		htmlStr += '</div>';
		htmlStr += '</div>';
	});
	$('#ironsList').append(htmlStr);
};


$(document).ready(function(){   


	
findAll();

document.getElementById("cartCount").innerHTML = getCartCount();

});
