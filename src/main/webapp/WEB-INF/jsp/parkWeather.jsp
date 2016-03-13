<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<html>

	<head>
		<title>National Park Geek</title>
		<c:url var="cssHref" value="/css/site.css" />
		<link type="text/css" rel="stylesheet" href="${cssHref}"/>
	</head>
	<body>
		<header>
			<c:url var="logoSrc" value="/img/logo.png" />			
			<img id="logo" src="${logoSrc}" alt="National Park Geek Logo"/>
		</header>
		
		<h1><c:out value="${parkToShow.name}"/></h1>
		
		
		<div class="bigPicture">
			
				<c:set var="weatherName" value="${oneParkWeatherList[0].forecast}"/>
				<c:if test="${oneParkWeatherList[0].forecast == 'partly cloudy'}" >
				<c:set var="weatherName" value="partlyCloudy" /> </c:if>
					
				<c:url var="parkWeatherSrc" value="/img/weather/${weatherName}.png" />
				<img src="${parkWeatherSrc}" alt="Picture of <c:out value="${oneParkWeatherList[0].forecast}"/>"/>
		</div>
		
		<div class="today"> 
			<h2>Today's Weather</h2>
			<c:set var="now" value="<%=new java.util.Date()%>" />
			<fmt:formatDate type="date" value="${now}" />
			<p><strong>High: </strong>${oneParkWeatherList[0].high} </p>
			<p><strong>Low: </strong>${oneParkWeatherList[0].low}</p>
			<p><strong>Forecast: </strong>${oneParkWeatherList[0].forecast}</p>
		
		</div>
		
		<div class="advice">
			<h2>Weather-based advice for today:</h2>
				<c:choose>
				
				
					<c:when test="${oneParkWeatherList[0].forecast =='snow' and oneParkWeatherList[0].high - oneParkWeatherList[0].low > 20}">
					<c:out value="Make sure to pack snowshoes, and make sure to wear breathable layers of clothing!"/>
					</c:when>
				
					<c:when test="${oneParkWeatherList[0].forecast =='snow'}">
					<c:out value="Make sure to pack snowshoes!"/>
					</c:when>
					
					<c:when test="${oneParkWeatherList[0].forecast =='rain'}">
					<c:out value="Make sure to pack rain gear and waterproof shoes!"/>
					</c:when>
				
					<c:when test="${oneParkWeatherList[0].forecast =='thunderstorms'}">
					<c:out value="Please seek shelter and avoid hiking on exposed ridges or mountaintops!"/>
					</c:when>
				
					<c:when test="${oneParkWeatherList[0].forecast =='sunny' and oneParkWeatherList[0].high - oneParkWeatherList[0].low > 20}">
					<c:out value="Please pack sunblock to avoid harmful sun rays, and make sure to wear breathable layers of clothing!"/>
					</c:when>
				
				
					<c:when test="${oneParkWeatherList[0].forecast =='sunny'}">
					<c:out value="Please pack sunblock to avoid harmful sun rays!"/>
					</c:when>
					
					<c:when test="${oneParkWeatherList[0].high > 75}">
					<c:out value="Please bring an extra gallon of water!"/>
					</c:when>
					
					<c:when test="${oneParkWeatherList[0].high - oneParkWeatherList[0].low > 20}">
					<c:out value="Make sure to wear breathable layers of clothing!"/>
					</c:when>
					
					<c:when test="${oneParkWeatherList[0].low < 20}">
					<c:out value="Exposure to very low temperatures is dangerous, you may suffer frostbite!"/>
					</c:when>
					
					<c:otherwise>
					<c:out value="No problems, enjoy your visit!"/>
					</c:otherwise>
					
				</c:choose>
		
			<div class="tempy">
			<p><strong>Toggle temperature units</strong><br>
				Currently showing: ${tempSession}
				<form method="GET" action="parkWeather">
					<input type="hidden" name="parkCode" value="${oneParkWeatherList[0].parkCode}">
 					<input type="radio" name="temp" value="Fahrenheit"> Fahrenheit<br>
  					<input type="radio" name="temp" value="Celsius"> Celsius<br><br>
  					
  					<input type="submit" name="Submit">
				</form> 
			</p>
			</div>
			
		</div>
		
		<table class="weatherDisplay">
		<tr>
			<th></th>
			<th>Tomorrow</th>
			<th>2 days from now</th>
			<th>3 days from now</th>
			<th>4 days from now</th>
		</tr>
		<tr>
			<th>Low</th>
			<c:forEach var="counter" begin="1" end="4">
				<td>${oneParkWeatherList[counter].low}</td>
			</c:forEach>
		</tr>
		
		<tr>
			<th>High</th>
			<c:forEach var="counter" begin="1" end="4">
				<td>${oneParkWeatherList[counter].high}</td>
			</c:forEach>
		</tr>
		
		<tr>
			<th>Forecast</th>
			<c:forEach var="counter" begin="1" end="4">
				<td>${oneParkWeatherList[counter].forecast}<br>
					<c:set var="weatherName" value="${oneParkWeatherList[counter].forecast}"/>
						<c:if test="${oneParkWeatherList[counter].forecast == 'partly cloudy'}" >
					<c:set var="weatherName" value="partlyCloudy" /> </c:if>
					
					<c:url var="parkWeatherSrc" value="/img/weather/${weatherName}.png" />
					<img src="${parkWeatherSrc}" alt="Picture of <c:out value="${oneParkWeatherList[counter].forecast}"/>"/>

				</td>
			</c:forEach>
	

			
		</tr>
		</table><br>
		
		
		
		
		
		<c:url var="parkList" value="/"></c:url>
					<a href="${parkList}">Return to Homepage</a>
	</body>
</html>