package com.techelevator.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.FileSystemParkDAO;
import com.techelevator.model.FileSystemWeatherDAO;
import com.techelevator.model.Park;
import com.techelevator.model.ParkDAO;
import com.techelevator.model.ParkWeatherDAO;
import com.techelevator.model.Weather;



@Controller
@SessionAttributes("temp")
public class ParkWeatherController {
	
	private ParkWeatherDAO parkWeatherDAO;
	private ParkDAO parkDAO;

	
	public ParkWeatherController(){
		InputStream parkWeatherDataInputStream = this.getClass().getResourceAsStream("/data/Weather.tsv");
		parkWeatherDAO= new FileSystemWeatherDAO(parkWeatherDataInputStream);
		InputStream parkDataInputStream = this.getClass().getResourceAsStream("/data/Parks.tsv");
		parkDAO = new FileSystemParkDAO(parkDataInputStream);
	}

	
	
	@RequestMapping(path="/parkWeather", method=RequestMethod.GET)
	public String displayWeatherDetail(Map<String, Object> modelWeatherDetail,
									@RequestParam(name="parkCode") String parkCode,
									@RequestParam(name="temp", required = false) String temp){
		
		List<Weather> oneParkWeatherList = new ArrayList<Weather>();
		Park parkToShow = null;
	
		if (temp == null || temp == "Fahrenheit"){
			temp = "Fahrenheit";
			modelWeatherDetail.put("temp", temp);
			oneParkWeatherList = (parkWeatherDAO.findWeatherByCode(parkCode));
			parkToShow = parkDAO.findParkByCode(parkCode);
		}
		else {
			temp = "Celsius";
			modelWeatherDetail.put("temp", temp);
			oneParkWeatherList = (parkWeatherDAO.findWeatherByCode(parkCode));
			parkToShow = parkDAO.findParkByCode(parkCode);
		}
		
		modelWeatherDetail.put("oneParkWeatherList", oneParkWeatherList);
		modelWeatherDetail.put("parkToShow", parkToShow);
		

		return "parkWeather";
	}
	
	
}