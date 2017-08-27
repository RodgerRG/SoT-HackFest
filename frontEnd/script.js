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
  });
  var icons = {
    police: {
      icon: 'police.png'
    },
    pharmacy: {
      icon: 'pharmacy.png'
    },
    hospital: {
      icon: 'hospital.png'
    },
    fire: {
      icon: 'fire.png'
    },
    doctor: {
      icon: 'doctor.png'
    }
  };
  var locations = [
          {
            position: new google.maps.LatLng(-36.8432579, 175.22630),
            type: 'fire'
          }, {
            position: new google.maps.LatLng(-36.8432579, 177.22820),
            type: 'doctor'
          }, {
            position: new google.maps.LatLng(-36.8432579, 178.22912),
            type: 'hospital'
          }, {
            position: new google.maps.LatLng(-36.8432579, 179.22907),
            type: 'police'
          }, {
            position: new google.maps.LatLng(-36.8432579, 174.23011),
            type: 'pharmacy'
          }
        ];
        locations.forEach(function(feature){
          var marker = new google.maps.Marker({
            position: feature.position,
            icon: icons[feature.type].icon,
            map:map
          })
        })
}

// function loadLocation(myPosition){
//     //port 4567
//     console.log( "ready!" );
//     debugger;
//     $.ajax({
//       url: "localhost:4567/locations/" + myPosition.lat + "/" + myPosition.lng
//     }).done(function(data) {
//       debugger;
//       var JSON = $.parseJSON(data);
//       debugger;
//       for each (location in locations){
//         buildLocationMarker(location);
//       }
//
//     });
// });

// function buildLocationMarker(){
//   var icons = {
//     police: {
//       icon: 'police.png'
//     },
//     pharmacy: {
//       icon: 'pharmacy.png'
//     },
//     hospital: {
//       icon: 'hospital.png'
//     },
//     fire: {
//       icon: 'fire.png'
//     },
//     doctor: {
//       icon: 'doctor.png'
//     }
//   };
//   var locations = [
//           {
//             position: new google.maps.LatLng(-33.91721, 151.22630),
//             type: 'fire'
//           }, {
//             position: new google.maps.LatLng(-33.91539, 151.22820),
//             type: 'doctor'
//           }, {
//             position: new google.maps.LatLng(-33.91747, 151.22912),
//             type: 'hospital'
//           }, {
//             position: new google.maps.LatLng(-33.91910, 151.22907),
//             type: 'police'
//           }, {
//             position: new google.maps.LatLng(-33.91725, 151.23011),
//             type: 'pharmacy'
//           }
//         ];
//   var myPosition = {lat: position.coords.latitude, lng: position.coords.longitude};
//   var map = new google.maps.Map(document.getElementById('googleMap'), {zoom: 18, center: myPosition});
//   var marker = new google.maps.Marker({
//     position: position,
//     map: map,
//   });
// }
