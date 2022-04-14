var rootUrl="http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest";
let cart = JSON.parse(localStorage.getItem('cart'))
let cartPrice = JSON.parse(localStorage.getItem('Cart Price Total'))

function addToCart(id){
    let cart = JSON.parse(localStorage.getItem('cart'))
    if(cart == null)
        cart = []
    cart.push(id)
    localStorage.setItem('cart', JSON.stringify(cart))
}

function addCartPrice(price){
    let cartPrice = JSON.parse(localStorage.getItem('Cart Price Total'))
    if(cartPrice == null)
        cartPrice = []
    cartPrice.push(price)
    localStorage.setItem('Cart Price Total', JSON.stringify(cartPrice))
}

function removeFromCart(id){
    let cart = JSON.parse(localStorage.getItem('cart'))
    if(cart == null)
        cart = []
    let index = cart.indexOf(id)
    cart.splice(index, 1)
        localStorage.setItem('cart', JSON.stringify(cart))
}

function removeFromPrice(price){
    let cartPrice = JSON.parse(localStorage.getItem('Cart Price Total'))
    if(cartPrice == null)
        cartPrice = []
    let index = cartPrice.indexOf(price)
    cartPrice.splice(index, 1)
        localStorage.setItem('Cart Price Total', JSON.stringify(cartPrice))
}
 


   function getCartCount() {
		let cart = JSON.parse(localStorage.getItem('cart'))
		if(cart == null)
			return 0;
		return cart.length;
		
}

function getPriceTotal() {
	let cartPrice = JSON.parse(localStorage.getItem('Cart Price Total'))
	var total = 0;
	for(var i=0; i < cartPrice.length; i++) {
		total += cartPrice[i];
	}
	console.log(total);
	return total;
}

function printCartProducts() {
	let cart = JSON.parse(localStorage.getItem('cart'))
	for (var i = 0; i < cart.length; i++) {
		$.ajax({
			type: 'GET',
			url: rootUrl + "/Products/search/id/" + cart[i],
			dataType: 'json',
			success:
				renderList2
		})
	}
}


addToOrders = function(productId, totalPrice, status) {
	let body = JSON.stringify({productId: productId, totalPrice: totalPrice, status: status})
	$.ajax({
		type: 'POST',
		url: rootUrl + "/Orders",
		dataType: 'json',
		contentType: "application/json",
		data: body,
		success: () => {
			console.log("Success");
		},
		error: (body) => {
			console.log("Error");
		}
	})
}

var renderList2 = function(list) {
	console.log(list)
	htmlStr = '';
	$('.details').remove();
	$.each(list, function(index, product) {
	 	htmlStr += '<div id= "" class="column">';
	 	htmlStr += '<div class="card">';
	 	htmlStr += '<img src="img/products/'+product.image+'" height="200px" width="200px">';
	 	htmlStr += '<p style="font-size:20px; color:white;">'+ product.make+ '</p>';
	 	htmlStr += '<p style="font-size:20px; color:white;">'+ product.model+ '</p>';
	 	htmlStr += '<p style="font-size:20px; color:white;">€ '+ product.price+ '</p>';
	 	htmlStr += '<li class="infoButton"><a href="" class="button2" onclick="removeFromCart('+product.productId+'); removeFromPrice('+product.price+');"> Remove From Cart </a></li>'
	 	htmlStr += '</div>';
	 	htmlStr += '</div>';
	 });
	 $('#cartList').append(htmlStr);
};




$(document).ready(function(){   

printCartProducts();



document.getElementById("priceTotal").innerHTML = getPriceTotal().toFixed(2);

//console.log(printCartProducts())

});

