var rootUrl="http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest";

createUser = function(id, firstname, lastname, contactNumber, email, password) {
	var encodedPassword = btoa(password);
	let body = JSON.stringify({customerId: id, firstName: firstname, lastName: lastname, contactNumber: contactNumber, emailAddress: email, password: encodedPassword})
	console.log(body);


	$.ajax({
		type: 'POST',
		url: rootUrl+"/Customers",
		dataType: 'json',
		contentType: "application/json",
		data: body,
		success: () => {
			alert("User Added to Database")
		},
		error: (body) => {
			console.log("Error");
			console.log(body);
		}
	})


}




$(document).ready(function(){   



});


