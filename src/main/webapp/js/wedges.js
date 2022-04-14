
var rootUrl="http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest";



var findAll=function(){
	$.ajax({type:'GET',
        url:rootUrl + "/Products/search/Wedges",
        dataType:'json',
        success:
        	renderList
        
});
}



var renderList = function(list) {
	console.log(list)
	htmlStr = '';
	$('.details').remove();
	$.each(list, function(index, wedge) {
		htmlStr += '<div id= "'+wedge.productId+'" class="column">';
		htmlStr += '<div class="card">';
		htmlStr += '<img src="img/products/'+wedge.image+'" height="200px" width="200px">';
		htmlStr += '<p style="font-size:20px; color:white;">'+ wedge.make+ '</p>';
		htmlStr += '<p style="font-size:20px; color:white;">'+ wedge.model+ '</p>';
		htmlStr += '<p style="font-size:20px; color:white;">€ '+ wedge.price+ '</p>';
		htmlStr += '<li class="infoButton"><a href="" class="button2" onclick="addToCart('+wedge.productId+') ; addCartPrice('+wedge.price+');"> Add To Cart </a></li>'
		htmlStr += '</div>';
		htmlStr += '</div>';
	});
	$('#wedgeList').append(htmlStr);
};







$(document).ready(function(){   

	
findAll();
document.getElementById("cartCount").innerHTML = getCartCount();
});