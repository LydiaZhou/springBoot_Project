let params = new URLSearchParams(location.search);
var street = params.get('streetaddress');
var city = params.getAll('city');

$(document).ready(function(){

    document.getElementById("address").innerHTML = street + "<br>"+ city;

});