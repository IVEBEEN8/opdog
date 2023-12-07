$(document).ready(function(){
	

    function initMap() {
        var mapContainer = document.getElementById('map');
        var options = {
            center: new kakao.maps.LatLng(37.5665, 126.9780), // Seoul, South Korea
            level: 12
        };
        var map = new kakao.maps.Map(mapContainer, options);

        var apiUrl = 'https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo?serviceKey=sJG8TCmXj96iwKxnSPRAaGazSqjp8g97CNLXDwtsv7BNaDo%2F6qhQtG3OIp0MAEreldhU5TicAqKPPvCVcrj7cA%3D%3D&numOfRows=1000&pageNo=1&_type=json';

        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                var markers = data.response.body.items.item.map(item => {
                    return new kakao.maps.Marker({
                        position: new kakao.maps.LatLng(parseFloat(item.lat), parseFloat(item.lng)),
                        clickable: true
                    });
                });

                kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
                    var latlng = mouseEvent.latLng;

                    var geocoder = new kakao.maps.services.Geocoder();
                    geocoder.coord2Address(latlng.getLng(), latlng.getLat(), function (result, status) {
                        if (status === kakao.maps.services.Status.OK) {
                            var address = result[0].address.address_name;

                            var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
                            message += '경도는 ' + latlng.getLng() + ' 이며, 주소는 ' + address + ' 입니다';

                            var resultDiv = document.getElementById('result');
                            resultDiv.innerHTML = message;
                        }
                    });
                });

                var clusterer = new kakao.maps.MarkerClusterer({
                    map: map,
                    averageCenter: true,
                    minLevel: 10
                });

                clusterer.addMarkers(markers);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }
    // Load the KakaoMap SDK and initialize the map
    kakao.maps.load(initMap);

});
