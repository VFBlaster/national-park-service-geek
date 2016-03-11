package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class SimpleParkWeatherDAO implements ParkWeatherDAO{

	private List<Weather> weatherList;
	private List<Weather> oneParkWeatherList;

	
	public SimpleParkWeatherDAO(){
		weatherList = new ArrayList<Weather>();
		
		Weather weather1 = new Weather("GNP");
		weather1.setHigh("75");
		weather1.setLow("35");
		weather1.setDay("1");
		weather1.setForecast("rain");
		weatherList.add(weather1);
		
		Weather weather2 = new Weather("GNP");
		weather2.setHigh("85");
		weather2.setLow("45");
		weather2.setDay("2");
		weather2.setForecast("partly cloudy");
		weatherList.add(weather2);
		
		Weather weather3 = new Weather("GNP");
		weather3.setHigh("75");
		weather3.setLow("35");
		weather3.setDay("3");
		weather3.setForecast("cloudy");
		weatherList.add(weather3);
		
		Weather weather4 = new Weather("GNP");
		weather4.setHigh("75");
		weather4.setLow("35");
		weather4.setDay("4");
		weather4.setForecast("snow");
		weatherList.add(weather4);
	
		Weather weather5 = new Weather("GNP");
		weather5.setHigh("75");
		weather5.setLow("35");
		weather5.setDay("5");
		weather5.setForecast("sunny");
		weatherList.add(weather5);
		
		Weather weatherGCNP1 = new Weather("GCNP");
		weatherGCNP1.setHigh("70");
		weatherGCNP1.setLow("40");
		weatherGCNP1.setDay("1");
		weatherGCNP1.setForecast("sunny");
		weatherList.add(weatherGCNP1);
		
		Weather weatherGCNP2 = new Weather("GCNP");
		weatherGCNP2.setHigh("80");
		weatherGCNP2.setLow("50");
		weatherGCNP2.setDay("2");
		weatherGCNP2.setForecast("rain");
		weatherList.add(weatherGCNP2);
		
		Weather weatherGCNP3 = new Weather("GCNP");
		weatherGCNP3.setHigh("78");
		weatherGCNP3.setLow("42");
		weatherGCNP3.setDay("3");
		weatherGCNP3.setForecast("partly cloudy");
		weatherList.add(weatherGCNP3);
		
		Weather weatherGCNP4 = new Weather("GCNP");
		weatherGCNP4.setHigh("82");
		weatherGCNP4.setLow("39");
		weatherGCNP4.setDay("4");
		weatherGCNP4.setForecast("thunderstorm");
		weatherList.add(weatherGCNP4);
	
		Weather weatherGCNP5 = new Weather("GCNP");
		weatherGCNP5.setHigh("38");
		weatherGCNP5.setLow("32");
		weatherGCNP5.setDay("5");
		weatherGCNP5.setForecast("snow");
		weatherList.add(weatherGCNP5);
		
		
	}
	
	
	@Override
	public List<Weather> readAllWeather() {
		

		return weatherList;
	}

	@Override
	public List<Weather> findWeatherByCode(String parkCode) {
		oneParkWeatherList = new ArrayList<Weather>();
		Weather desired = null;
		
		for (Weather w : weatherList){
			if(w.getParkCode().equals(parkCode)){
				desired = w;
				oneParkWeatherList.add(desired);
			}
		}
		return oneParkWeatherList;
	}

}
