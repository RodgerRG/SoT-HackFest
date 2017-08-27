function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(loadLocation);
    } else {
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
}

var map;

function loadLocation(position){
    //port 4567
    console.log("ready!");
    console.log(position);
    $.ajax({
      url: "http://localhost:4567/locations/" + position.coords.latitude + "/" + position.coords.longitude,
      //crossDomain: true,
      dataType: 'json'

    }).done(function (data) {
        console.log("got data");
        
      ///*var data = [{"name":"Lambs Pharmacy \u0026 Natural Therapies Centre","latitude":-36.8577631,"longitude":174.7602813,"openingTime":0,"closi*/ngTime":0,"rating":4.1,"type":"UNKNOWN"},{"name":"Net Pharmacy","latitude":-36.85328489999999,"longitude":174.7789032,"openingTime":0,"closingTime":0,"rating":4.1,"type":"UNKNOWN"},{"name":"Plastic Surgery Auckland","latitude":-36.8738877,"longitude":174.7797247,"openingTime":0,"closingTime":0,"rating":2.6,"type":"UNKNOWN"},{"name":"Starship Children\u0027s Hospital","latitude":-36.859678,"longitude":174.769864,"openingTime":0,"closingTime":0,"rating":4.5,"type":"UNKNOWN"},{"name":"Grace Osteopathy - Grey Lynn","latitude":-36.86451539999999,"longitude":174.737932,"openingTime":0,"closingTime":0,"rating":5.0,"type":"UNKNOWN"},{"name":"Auckland City Hospital","latitude":-36.8604597,"longitude":174.7691264,"openingTime":0,"closingTime":0,"rating":4.0,"type":"UNKNOWN"},{"name":"Speight\u0027s Podiatry","latitude":-36.8480332,"longitude":174.7664249,"openingTime":0,"closingTime":0,"rating":3.7,"type":"UNKNOWN"},{"name":"Ponsonby Podiatry","latitude":-36.845954,"longitude":174.733386,"openingTime":0,"closingTime":0,"rating":5.0,"type":"UNKNOWN"},{"name":"Eye Institute","latitude":-36.8746423,"longitude":174.783508,"openingTime":0,"closingTime":0,"rating":4.7,"type":"UNKNOWN"},{"name":"Dominion Road Pharmacy","latitude":-36.8725222,"longitude":174.7519965,"openingTime":0,"closingTime":0,"rating":4.0,"type":"UNKNOWN"},{"name":"Kingsland Pharmacy","latitude":-36.87208,"longitude":174.744246,"openingTime":0,"closingTime":0,"rating":4.0,"type":"UNKNOWN"},{"name":"Auckland Central Police Station","latitude":-36.8520637,"longitude":174.7604348,"openingTime":0,"closingTime":0,"rating":3.3,"type":"UNKNOWN"},{"name":"Alpers Dental","latitude":-36.87747039999999,"longitude":174.7771141,"openingTime":0,"closingTime":0,"rating":4.8,"type":"UNKNOWN"},{"name":"Dr Gregory Taylor Ltd","latitude":-36.87406060000001,"longitude":174.7838807,"openingTime":0,"closingTime":0,"rating":0.0,"type":"UNKNOWN"},{"name":"Ashley and Martin - Hair Loss Medical Center - Auckland","latitude":-36.866436,"longitude":174.777123,"openingTime":0,"closingTime":0,"rating":3.3,"type":"UNKNOWN"},{"name":"Surrey Medical Centre","latitude":-36.8635247,"longitude":174.7369025,"openingTime":0,"closingTime":0,"rating":5.0,"type":"UNKNOWN"},{"name":"Lumino The Dentists - Head Office","latitude":-36.844525,"longitude":174.765099,"openingTime":0,"closingTime":0,"rating":0.0,"type":"UNKNOWN"},{"name":"Casley, Wong \u0026 Tam Dental","latitude":-36.8701594,"longitude":174.7759106,"openingTime":0,"closingTime":0,"rating":5.0,"type":"UNKNOWN"},{"name":"Auckland Sports Podiatry Parnell","latitude":-36.854526,"longitude":174.779645,"openingTime":0,"closingTime":0,"rating":5.0,"type":"UNKNOWN"},{"name":"The Orthopaedic Clinic","latitude":-36.8737428,"longitude":174.7698265,"openingTime":0,"closingTime":0,"rating":5.0,"type":"UNKNOWN"}];

      var myPosition = {lat: position.coords.latitude, lng: position.coords.longitude};
      map = new google.maps.Map(document.getElementById('googleMap'), {zoom: 18, center: myPosition});
      var marker = new google.maps.Marker({
        position: myPosition,
        map: map,
      
      });
      for (var index in data) {
          var location = data[index];
          buildLocationMarker(location);
      }
      return;
    });
}

function buildLocationMarker(location){
    var icons = {
        POLICE: {
            icon: 'police.png'
        },
        PHARMACY: {
            icon: 'pharmacy.png'
        },
        HOSPITAL: {
            icon: 'hospital.png'
        },
        FIRESERVICE: {
            icon: 'fire.png'
        },
        GP: {
            icon: 'doctor.png'
        },
        UNKNOWN: {
            icon: '?.png'
        }
    };
    var position = {lat: location.latitude, lng: location.longitude};
    var marker = new google.maps.Marker({
        position: position,
        icon: icons[location.type].icon,
        map:map
    });
}
