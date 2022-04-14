var rootUrl="http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest";


const getOrders = () => {
    $.ajax({
        type: 'GET',
        url: rootUrl+'/Orders',
        dataType: 'json',
        contentType: "application/json",
        success: function(data) {
            var jsonData = data;
            setDataToOrdersTable(jsonData);
        },
        error: (data) => {
            console.log(data);
        }
    })

}

function setDataToOrdersTable(jsonData){
    console.log(jsonData);
    $('#tableOrders').DataTable( {
        pagination: "bootstrap",
        filter:true,
        data: jsonData,
        columns: [ {'data': 'orderNumber'},
            { 'data': 'productId'},
            { 'data': 'totalPrice'},
            { 'data': 'status'}],
        destroy: true,
        lengthMenu:[5,10,25],
        pageLength: 5
    } );
}

$(document).ready(function(){

    getOrders()

});