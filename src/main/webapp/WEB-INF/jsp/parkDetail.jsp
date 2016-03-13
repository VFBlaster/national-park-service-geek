<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


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
					<h1>${parkToShow.name}</h1>
					<p class="parkImage" >
					<c:set var="parkImageName" value="${parkToShow.parkCode}"/>
					<c:url var="parkImgSrc" value="/img/parks/${fn:toLowerCase(parkImageName)}.jpg" />
					<img src="${parkImgSrc}" alt="Picture of <c:out value="${parkToShow.name}"/>"/>
					</p>
					
					<p class="describe"><c:out value="${parkToShow.description}"/></p>	
					
			
					<ul>
						<li>Location: <c:out value="${parkToShow.location}"/></li>
						<li>Acreage: <c:out value="${parkToShow.acreage}"/></li>
						<li>Elevation: <c:out value="${parkToShow.elevation}"/></li>
						<li>Miles of trail: <c:out value="${parkToShow.milesOfTrail}"/></li>
						<li>Number of campsites: <c:out value="${parkToShow.numberOfCampsites}"/></li>
						<li>Year founded: <c:out value="${parkToShow.yearFounded}"/></li>
						<li>Climate: <c:out value="${parkToShow.climate}"/></li> 
						<li>Annual Visitors: <c:out value="${parkToShow.annualVisitorCount}"/></li>
						<li>Quote: <em><c:out value="${parkToShow.quote}"/></em><c:out value=" - ${parkToShow.quoteSource}"/> </li>
				
						<li>Entry Fee: <c:out value="${parkToShow.entryFee}"/></li>
						<li>Number of species: <c:out value="${parkToShow.numberOfSpecies}"/></li>
						 
						
					</ul>
		
					<h3>
						<c:url var="parkWeatherHref" value="/parkWeather">
							<c:param name="parkCode" value="${parkToShow.parkCode}" />
						</c:url>
						<a href="${parkWeatherHref}">Click for the weather forecast at <c:out value="${parkToShow.name}"/></a>
					</h3>			
					
		
					<c:url var="parkList" value="/"></c:url>
					<a href="${parkList}">Return to Homepage</a>
					
		
		
	</body>
</html>
	