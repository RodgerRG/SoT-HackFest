function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(myMap);
    } else {
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
}

function myMap(position) {
var lat = position.coords.latitude;
var lng = position.coords.longitude;
var mapProp= {
    center:new google.maps.LatLng(lat, lng),
    zoom:18,
};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
