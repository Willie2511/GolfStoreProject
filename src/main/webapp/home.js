var rootUrl="http://localhost:8080/GolfStore/rest";






var findAll=function(){
	$.ajax({type:'GET',
        url:rootUrl + "/categories",
        dataType:'json',
        success:
        	renderList
        
});
}



var renderList = function(list) {
	console.log(list)
	htmlStr = '';
	$('.details').remove();
	$.each(list, function(index, categories) {
		htmlStr += '<div id= "'+categories.id+'" class="column">';
		htmlStr += '<div class="card">';
		htmlStr += '<img src="img/categories/'+categories.image+'" height="200px" width="200px">';
		htmlStr += '<p style="font-size:20px; color:white;">'+ categories.name+ '</p>';
		htmlStr += '<li class="infoButton"><a href="'+categories.name+'.html" class="button2"> Select </a></li>'
		htmlStr += '</div>';
		htmlStr += '</div>';
	});
	$('#categoryList').append(htmlStr);
};




$(document).ready(function(){
	

	
findAll();
document.getElementById("cartCount").innerHTML = getCartCount();

});

