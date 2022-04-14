var rootUrl="http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest";



checkout = function (cardNum, expiry, cvc){
	let body = JSON.stringify({cardNum: cardNum, expiry: expiry, cvc: cvc})
	var encodedCardNum = btoa(cardNum);


	$.ajax({
		type: 'GET',
		url: rootUrl+"/PaymentDetails/search/"+encodedCardNum,
		dataType: "json",
		success: function(data) {
			console.log(getPriceTotal());
			console.log(data);
			for(i=0; i<data.length; i++) {
					
				if(encodedCardNum == data[i].cardNum && cvc == data[i].cvc) {
					let text = "Are You Sure You Want To Complete Payment For This Purchase?\nOrders Cannot Be Cancelled After Payment Is Received \nPress OK to Proceed or Cancel.";
  					if (confirm(text) == true) {
						alert("Your Payment Has Been Received\nYou Will Be Notified When Your Order Has Been Dispatched")
						addProductsToOrdersTable();
						window.localStorage.clear();
    					window.location.href="home.html";
    					
  					} else {
    					alert("You Have Canceled Your Payment!");
 					 }
				} else {
					alert("Incorrect Payment Details");
				}
			}
		}})  
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

function addProductsToOrdersTable() {
	let cart = JSON.parse(localStorage.getItem('cart'))
	for (var i = 0; i < cart.length; i++) {
		$.ajax({
			type: 'GET',
			url: rootUrl + "/Products/search/id/" + cart[i],
			dataType: 'json',
			success: function(data) {
				for(var i = 0; i < data.length; i++) {
					addToOrders(data[i].productId, data[i].price, "In Progress");
					console.log("success");
				}

		}}
	)}}

$(document).ready(function(){   



document.getElementById("paymentTotal").innerHTML = getPriceTotal().toFixed(2);


});

