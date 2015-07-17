$(document).ready(function(){

    google.maps.event.addDomListener(window, 'load', initialize);

});

function initialize() {
  var map;
  var mapOptions = {
    zoom: 15
  };
  map = new google.maps.Map(document.getElementById('googleMap'),
      mapOptions);

  // Try HTML5 geolocation
  if(navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
      var pos = new google.maps.LatLng(position.coords.latitude + getRandomArbitrary(0.001,0.02),
                                       position.coords.longitude + getRandomArbitrary(0.001,0.02));

      marker = new google.maps.Marker({
        map:map,
        draggable:true,
        animation: google.maps.Animation.DROP,
        position: pos,
      });
      google.maps.event.addListener(marker, 'click', toggleBounce);

      map.setCenter(pos);
    }, function() {
      handleNoGeolocation(true);
    });
  } else {
    // Browser doesn't support Geolocation
    handleNoGeolocation(false);
  }
}

function toggleBounce() {

  if (marker.getAnimation() != null) {
    marker.setAnimation(null);
  } else {
    marker.setAnimation(google.maps.Animation.BOUNCE);
  }
}

function handleNoGeolocation(errorFlag) {
  if (errorFlag) {
    var content = 'Error: The Geolocation service failed.';
  } else {
    var content = 'Error: Your browser doesn\'t support geolocation.';
  }

  var options = {
    map: map,
    position: new google.maps.LatLng(39, 2),
    content: content
  };

  var infowindow = new google.maps.InfoWindow(options);
  map.setCenter(options.position);
}

function getRandomArbitrary(min, max) {
    return Math.random() * (max - min) + min;
}
