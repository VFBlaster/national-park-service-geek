package com.techelevator.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Park;
import com.techelevator.model.ParkDAO;
import com.techelevator.model.ParkWeatherDAO;
import com.techelevator.model.SimpleParkDAO;
import com.techelevator.model.SimpleParkWeatherDAO;
import com.techelevator.model.Weather;



@Controller
public class ParkWeatherController {
	
	private ParkWeatherDAO parkWeatherDAO;
	private ParkDAO parkDAO;
	
	public ParkWeatherController(){
		parkWeatherDAO = new SimpleParkWeatherDAO();
		parkDAO = new SimpleParkDAO();
	}
	

	@RequestMapping(path="/parkWeather", method=RequestMethod.GET)
	public String displayWeatherDetail(Map<String, Object> modelWeatherDetail,
									 @RequestParam(name="parkCode") String parkCode) {
		
		Park parkToShow = parkDAO.findParkByCode(parkCode);
		modelWeatherDetail.put("parkToShow", parkToShow); 
		
		Weather today = parkWeatherDAO.findWeatherByCode(parkCode);
		List<Weather> weatherList = parkWeatherDAO.readAllWeather();
		modelWeatherDetail.put("weatherList", weatherList);
		modelWeatherDetail.put("today", today);
	
		return "parkWeather";
	}
	
	
	
	
	
	
	
}
