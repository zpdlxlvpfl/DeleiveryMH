<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Delivery TEST Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/fontAwesome.css">
<link rel="stylesheet" href="resources/css/hero-slider.css">
<link rel="stylesheet" href="resources/css/templatemo-main.css">
<link rel="stylesheet" href="resources/css/owl-carousel.css">



<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800"
	rel="stylesheet">

<script src="resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	type="text/javascript"></script>

<script>
	window.jQuery
			|| document
					.write(
							'<script src="https://code.jquery.com/jquery-3.4.1.min.js" ><\/script>')
</script>
<script src="resources/js/vendor/bootstrap.min.js"></script>
<script src="resources/js/plugins.js"></script>
<script src="resources/js/main.js"></script>

 <style>
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:500px;}
#menu_wrap {position:absolute;top:0;left:100px;bottom:0;width:400px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px;}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}
#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default;color:#777;}
</style>

</head>


<body>
	<form name="Logout" action="/logout" method="post">
		<div class="fixed-side-navbar">
			<ul class="nav flex-column">
				<li class="nav-item"><a class="nav-link" href="#"><span>Delivery</span></a></li>
				<li class="nav-item"><a class="nav-link" href="restList"><span>Restaurant List</span></a></li>
				<sec:authorize access="isAnonymous()">
					<li class="nav-item"><a class="nav-link" href="login"><span>LOGIN</span></a></li>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<li class="nav-item"><a class="nav-link" href="join"><span>JOIN</span></a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="nav-item"><a class="nav-link" href="#"
						onclick="location.href='/member/myInfo'"><span>MYPAGE</span></a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="nav-item"><a class="nav-link" href="#"
						onclick="javascript:document.Logout.submit();"><span>LOGOUT</span></a></li>
				</sec:authorize>
			</ul>
		</div>
		<input type="hidden" name="${_csrf.parameterName }"
			value="${_csrf.token }" />
	</form>

	<div class="parallax-content baner-content" id="home">
		<div class="container">
			<div class="first-content">
				<h1>Delivery TEST</h1>
				<span><em>Bootstrap</em>Delivery TEST</span>
				<div class="primary-button">
					<br> <a href="#services">More</a>
				</div>
			</div>
		</div>
	</div>


	<div class="service-content" id="services">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="left-text">
						<h4>Delivery TEST</h4>
						<div class="line-dec"></div>
						<p>
							Delivery TEST abcdefgsadqasdfaffadac <a rel="nofollow"
								href="https://templatemo.com"> website</a> whsskwhfflek.
						</p>
						<ul>
							<li>- test test test test test test</li>
							<li>- test test test test test test</li>
							<li>- test test test test test test</li>
							<li>- test test test test test test</li>
						</ul>
						<div class="primary-button">
							<a href="#portfolio">Delivery TEST</a>
						</div>
					</div>
				</div>

				<div class="col-md-8">
					<div class="row">

						<c:forEach items="${restList}" var="RES_CODE" begin="0" end="3"
							step="1" varStatus="i">

							<div class="col-md-6">
								<div class="service-item">
									<input type="hidden" id="RES_CODE" name="RES_CODE"
										value='<c:out value="${RES_CODE.RES_CODE }" />'>
									<h4>
										<a href="/menuList?RES_CODE=${RES_CODE.RES_CODE}">
											${RES_CODE.RES_NAME }</a>
									</h4>
									<div class="line-dec"></div>
									<p>${RES_CODE.RES_INFO }</p>
									<p>
										Delivery Tips : ${RES_CODE.DEL_PRICE }<font color="orange">
											&#8361; </font>
									</p>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="parallax-content projects-content" id="portfolio">


		<div class="container">

			<div class="row">

				<div class="col-md-12">

					<div id="owl-testimonials" class="owl-carousel owl-theme">




						<div class="item">
							<div class="testimonials-item">
								<img src="resources/img/0st-item.jpg">
								<div class="text-content">

									<c:forEach items="${mainmenuList}" var="mainmenuList" begin="0"
										end="0" step="1" varStatus="i">
										<h4>
											<c:out value=" ${mainmenuList.res_menu_name}">
											</c:out>
										</h4>
										<span><c:out value="${mainmenuList.res_menu_price}"></c:out>
											&#8361;</span>
									</c:forEach>

								</div>
							</div>
						</div>




						<div class="item">
							<div class="testimonials-item">
								<a href="resources/img/1st-big-item.jpg" data-lightbox="image-1"><img
									src="resources/img/1st-item.jpg" alt=""></a>
								<div class="text-content">

									<c:forEach items="${mainmenuList}" var="res_code" begin="1"
										end="1" step="1" varStatus="i">
										<h4>
											<c:out value=" ${res_code.res_menu_name}">
											</c:out>
										</h4>
										<span><c:out value="${res_code.res_menu_price}"></c:out>
											&#8361;</span>
									</c:forEach>

								</div>
							</div>
						</div>


						<div class="item">
							<div class="testimonials-item">
								<a href="resources/img/2nd-big-item.jpg" data-lightbox="image-1"><img
									src="resources/img/2nd-item.jpg" alt="" id=""></a>
								<div class="text-content">
									<c:forEach items="${mainmenuList}" var="res_code" begin="2"
										end="2" step="1" varStatus="i">
										<h4>
											<c:out value=" ${res_code.res_menu_name}">
											</c:out>
										</h4>
										<span><c:out value="${res_code.res_menu_price}"></c:out>
											&#8361;</span>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="resources/img/3rd-big-item.jpg" data-lightbox="image-1"><img
									src="resources/img/3rd-item.jpg" alt="" id=""></a>
								<div class="text-content">
									<c:forEach items="${mainmenuList}" var="res_code" begin="3"
										end="3" step="1" varStatus="i">
										<h4>
											<c:out value="${res_code.res_menu_name}" />
										</h4>
										<span><c:out value="${res_code.res_menu_price}" />&#8361;
										</span>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="resources/img/4th-big-item.jpg" data-lightbox="image-1"><img
									src="resources/img/4th-item.jpg" alt="" id="$"></a>
								<div class="text-content">
									<c:forEach items="${mainmenuList}" var="res_code" begin="4"
										end="4" step="1" varStatus="i">
										<h4>
											<c:out value="${res_code.res_menu_name}" />
										</h4>
										<span><c:out value="${res_code.res_menu_price}"></c:out>&#8361;
										</span>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="resources/img/5th-big-item.jpg" data-lightbox="image-1"><img
									src="resources/img/5th-item.jpg" alt="" id=""></a>
								<div class="text-content">
									<c:forEach items="${mainmenuList}" var="res_code" begin="5"
										end="5" step="1" varStatus="i">
										<h4>
											<c:out value="${res_code.res_menu_name}" />
										</h4>
										<span><c:out value="${res_code.res_menu_price}"></c:out>&#8361;
										</span>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimonials-item">
								<a href="resources/img/6th-big-item.jpg" data-lightbox="image-1"><img
									src="resources/img/6th-item.jpg" alt="" id=""></a>
								<div class="text-content">
									<c:forEach items="${mainmenuList}" var="res_code" begin="6"
										end="6" step="1" varStatus="i">
										<h4>
											<c:out value="${res_code.res_menu_name}" />
										</h4>
										<span><c:out value="${res_code.res_menu_price}"></c:out>&#8361;
										</span>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>





	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c1ae9605eb7fea18b91aa4e9f1d11e64&libraries=services,clusterer,drawing"></script>
	<div class="parallax-content contact-content" id="contact-us">
		<div class="container">
			<div class="row">

				<div class="col-md-6">
					<div class="map">
						<div id="map" style="width: 100%; height: 476px;"></div>
						<!-- 현재위치 -->


					</div>
				</div> <br>

				<div class="col-md-6">
					<div class="map_wrap">

						<div id="menu_wrap" class="bg_white">
							<div class="option">
								<div>
									<form onsubmit="searchPlaces(); return false;">
										키워드 : <input type="text" value="수원 맛집" id="keyword" size="15">
										<button type="submit">검색하기</button>
									</form>
								</div>
							</div>
							<hr>
							<ul id="placesList"></ul>
							<div id="pagination"></div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>






	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 2
		// 지도의 확대 레벨 
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성

		//HTML5의 geolocation으로 사용할 수 있는지 확인
		if (navigator.geolocation) {

			// GeoLocation을 이용해서 접속 위치를 얻음
			navigator.geolocation.getCurrentPosition(function(position) {

				var lat = position.coords.latitude, // 위도
				lon = position.coords.longitude; // 경도

				var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성 
				message = '<div style="padding:5px;">현재위치</div>'; // 인포윈도우에 표시될 내용 

				// 마커와 인포윈도우를 표시 
				displayMarker(locPosition, message);

			});

		} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정 

			var locPosition = new kakao.maps.LatLng(33.450701, 126.570667), message = 'geolocation을 사용ㄴㄴㄴㄴ'

			displayMarker(locPosition, message);
		}

		//지도에 마커와 인포윈도우를 표시하는 함수 
		function displayMarker(locPosition, message) {

			// 마커를 생성 
			var marker = new kakao.maps.Marker({
				map : map,
				position : locPosition
			});

			var iwContent = message, // 인포윈도우에 표시할 내용
			iwRemoveable = true;

			// 인포윈도우를 생성
			var infowindow = new kakao.maps.InfoWindow({
				content : iwContent,
				removable : iwRemoveable
			});

			// 인포윈도우를 마커위에 표시  
			infowindow.open(map, marker);

			// 지도 중심좌표를 접속위치로 변경 
			map.setCenter(locPosition);
		}
		
		
		// 마커를 담을 배열 
		var markers = [];

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성     
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 장소 검색 객체를 생성 
		var ps = new kakao.maps.services.Places();

		// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성 
		var infowindow = new kakao.maps.InfoWindow({
			zIndex : 1
		});

		// 키워드로 장소를 검색 
		searchPlaces();

		// 키워드 검색을 요청하는 함수 
		function searchPlaces() {

			var keyword = document.getElementById('keyword').value;

			if (!keyword.replace(/^\s+|\s+$/g, '')) {
				alert('키워드를 입력해주세요!');
				return false;
			}

			// 장소검색 객체를 통해 키워드로 장소검색을 요청 
			ps.keywordSearch(keyword, placesSearchCB);
		}

		// 장소검색이 완료됐을 때 호출되는 콜백함수  
		function placesSearchCB(data, status, pagination) {
			if (status === kakao.maps.services.Status.OK) {

				// 정상적으로 검색이 완료됐으면
				// 검색 목록과 마커를 표출 
				displayPlaces(data);

				// 페이지 번호를 표출 
				displayPagination(pagination);

			} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

				alert('검색 결과가 존재하지 않습니다.');
				return;

			} else if (status === kakao.maps.services.Status.ERROR) {

				alert('검색 결과 중 오류가 발생했습니다.');
				return;

			}
		}

		// 검색 결과 목록과 마커를 표출하는 함수 
		function displayPlaces(places) {

			var listEl = document.getElementById('placesList'), menuEl = document
					.getElementById('menu_wrap'), fragment = document
					.createDocumentFragment(), bounds = new kakao.maps.LatLngBounds(), listStr = '';

			// 검색 결과 목록에 추가된 항목들을 제거 
			removeAllChildNods(listEl);

			// 지도에 표시되고 있는 마커를 제거 
			removeMarker();

			for (var i = 0; i < places.length; i++) {

				// 마커를 생성하고 지도에 표시 
				var placePosition = new kakao.maps.LatLng(places[i].y,
						places[i].x), marker = addMarker(placePosition, i), itemEl = getListItem(
						i, places[i]); // 검색 결과 항목 Element를 생성 

				// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
				// LatLngBounds 객체에 좌표를 추가 
				bounds.extend(placePosition);

				// 마커와 검색결과 항목에 mouseover 했을때
				// 해당 장소에 인포윈도우에 장소명을 표시 
				// mouseout 했을 때는 인포윈도우를 닫습니다
				(function(marker, title) {
					kakao.maps.event.addListener(marker, 'mouseover',
							function() {
								displayInfowindow(marker, title);
							});

					kakao.maps.event.addListener(marker, 'mouseout',
							function() {
								infowindow.close();
							});

					itemEl.onmouseover = function() {
						displayInfowindow(marker, title);
					};

					itemEl.onmouseout = function() {
						infowindow.close();
					};
				})(marker, places[i].place_name);

				fragment.appendChild(itemEl);
			}

			// 검색결과 항목들을 검색결과 목록 Elemnet에 추가 
			listEl.appendChild(fragment);
			menuEl.scrollTop = 0;

			// 검색된 장소 위치를 기준으로 지도 범위를 재설정 
			map.setBounds(bounds);
		}

		// 검색결과 항목을 Element로 반환하는 함수 
		function getListItem(index, places) {

			var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
					+ (index + 1)
					+ '"></span>'
					+ '<div class="info">'
					+ '   <h5>' + places.place_name + '</h5>';

			if (places.road_address_name) {
				itemStr += '    <span>' + places.road_address_name + '</span>'
						+ '   <span class="jibun gray">' + places.address_name
						+ '</span>';
			} else {
				itemStr += '    <span>' + places.address_name + '</span>';
			}

			itemStr += '  <span class="tel">' + places.phone + '</span>'
					+ '</div>';

			el.innerHTML = itemStr;
			el.className = 'item';

			return el;
		}

		// 마커를 생성하고 지도 위에 마커를 표시하는 함수 
		function addMarker(position, idx, title) {
			var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
			imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
			imgOptions = {
				spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
				spriteOrigin : new kakao.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
				offset : new kakao.maps.Point(13, 37)
			// 마커 좌표에 일치시킬 이미지 내에서의 좌표
			}, markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize,
					imgOptions), marker = new kakao.maps.Marker({
				position : position, // 마커의 위치
				image : markerImage
			});

			marker.setMap(map); // 지도 위에 마커를 표출 
			markers.push(marker); // 배열에 생성된 마커를 추가 

			return marker;
		}

		// 지도 위에 표시되고 있는 마커를 모두 제거 
		function removeMarker() {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers = [];
		}

		// 검색결과 목록 하단에 페이지번호를 표시는 함수 
		function displayPagination(pagination) {
			var paginationEl = document.getElementById('pagination'), fragment = document
					.createDocumentFragment(), i;

			// 기존에 추가된 페이지번호를 삭제 
			while (paginationEl.hasChildNodes()) {
				paginationEl.removeChild(paginationEl.lastChild);
			}

			for (i = 1; i <= pagination.last; i++) {
				var el = document.createElement('a');
				el.href = "#";
				el.innerHTML = i;

				if (i === pagination.current) {
					el.className = 'on';
				} else {
					el.onclick = (function(i) {
						return function() {
							pagination.gotoPage(i);
						}
					})(i);
				}

				fragment.appendChild(el);
			}
			paginationEl.appendChild(fragment);
		}

		// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수 
		// 인포윈도우에 장소명을 표시 
		function displayInfowindow(marker, title) {
			var content = '<div style="padding:5px;z-index:1;">' + title
					+ '</div>';

			infowindow.setContent(content);
			infowindow.open(map, marker);
		}

		// 검색결과 목록의 자식 Element를 제거하는 함수 
		function removeAllChildNods(el) {
			while (el.hasChildNodes()) {
				el.removeChild(el.lastChild);
			}
		}

		//지도 추가 기능 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

		// 지도 타입 변경 컨트롤을 생성한다
		var mapTypeControl = new kakao.maps.MapTypeControl();

		// 지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
		map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

		// 지도에 확대 축소 컨트롤을 생성한다
		var zoomControl = new kakao.maps.ZoomControl();

		// 지도의 우측에 확대 축소 컨트롤을 추가한다
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

		// 지도 중심 좌표 변화 이벤트를 등록한다
		kakao.maps.event.addListener(map, 'center_changed', function() {
			console.log('지도의 중심 좌표는 ' + map.getCenter().toString());
		});

		// 지도 확대 레벨 변화 이벤트를 등록한다
		kakao.maps.event.addListener(map, 'zoom_changed', function() {
			console.log('지도의 현재 확대레벨은 ' + map.getLevel());
		});

		// 지도 영역 변화 이벤트를 등록한다
		kakao.maps.event.addListener(map, 'bounds_changed', function() {
			var mapBounds = map.getBounds(), message = '지도의 남서쪽, 북동쪽 영역좌표는 '
					+ mapBounds.toString();

			console.log(message);
		});

		// 지도 시점 변화 완료 이벤트를 등록한다
		kakao.maps.event.addListener(map, 'idle', function() {
			var message = '지도의 중심좌표는 ' + map.getCenter().toString() + ' 이고,'
					+ '확대 레벨은 ' + map.getLevel() + ' 레벨';
			console.log(message);
		});

		// 지도 클릭 이벤트를 등록한다 (좌클릭 : click, 우클릭 : rightclick, 더블클릭 : dblclick)
		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
			console.log('지도에서 클릭한 위치의 좌표는 ' + mouseEvent.latLng.toString());
		});

		// 지도 드래깅 이벤트를 등록한다 (드래그 시작 : dragstart, 드래그 종료 : dragend)
		kakao.maps.event.addListener(map, 'drag', function() {
			var message = '지도를 드래그 ' + '지도의 중심 좌표는 '
					+ map.getCenter().toString();
			console.log(message);
		});
	</script>


	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="primary-button">
						<a href="#home">Back To Top</a>
					</div>
					<ul>
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
						<li><a href="#"><i class="fa fa-google"></i></a></li>
						<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>





</body>
</html>