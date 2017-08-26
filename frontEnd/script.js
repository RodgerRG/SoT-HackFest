function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(initMap);
    } else {
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
}

function initMap(position){
  var myPosition = {lat: position.coords.latitude, lng: position.coords.longitude};
  var map = new google.maps.Map(document.getElementById('googleMap'), {zoom: 18, center: myPosition});
  var marker = new google.maps.Marker({
    position: myPosition,
    map: map,
    title: 'User Location'
  });
}
