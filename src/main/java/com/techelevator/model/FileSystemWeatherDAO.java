package com.techelevator.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


//+++++++++++++++++++++++++Fahrenheit-version!!+++++++++++++++++++++++++++++

public class FileSystemWeatherDAO implements ParkWeatherDAO {

	private List<Weather> weatherList;
	private List<Weather> oneParkWeatherList;	
	BufferedReader inputReader;

	
	public FileSystemWeatherDAO(InputStream input) {

		weatherList = new ArrayList<>();
		InputStreamReader reader = new InputStreamReader(input);
		inputReader = new BufferedReader(reader);
		throwAwayHeaderLine();
		String line = readNextLine();
		
		while(line != null){
			String[] fields = line.split("\t");
			Weather theWeather = new Weather(fields[0]);
			theWeather.setDay(fields[1]);
			theWeather.setLow(fields[2]);
			theWeather.setHigh(fields[3]);
			theWeather.setForecast(fields[4]);
			
			weatherList.add(theWeather);
			line = readNextLine();
		}
	
	}
	
	public List<Weather> readAllWeather(){
		return weatherList;
	}
	
	
	private String readNextLine() {
		String parkWeatherInfoLine = null;
		try{
			parkWeatherInfoLine =inputReader.readLine();
		} catch (IOException e){
		}
		return parkWeatherInfoLine;
	}
	
	
	private void throwAwayHeaderLine() {
		readNextLine();
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
