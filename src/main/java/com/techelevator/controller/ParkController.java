package com.techelevator.controller;

import java.io.InputStream;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.techelevator.model.FileSystemParkDAO;
import com.techelevator.model.Park;
import com.techelevator.model.ParkDAO;


@Controller
public class ParkController {
	
	private ParkDAO parkDAO;
	
	public ParkController(){
		InputStream parkDataInputStream = this.getClass().getResourceAsStream("/data/Parks.tsv");
		parkDAO= new FileSystemParkDAO(parkDataInputStream);
		
		//parkDAO = new SimpleParkDAO();
	}
	
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayParkList(Map<String, Object> modelListOfParks) {
		modelListOfParks.put("listOfParks", parkDAO.readAllParks());
		
		
		return "parkList";
	}
	
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetail(Map<String, Object> modelParkDetail,
									 @RequestParam(name="parkCode") String parkCode) {
		Park parkToShow = parkDAO.findParkByCode(parkCode);
		modelParkDetail.put("parkToShow", parkToShow);
	
		return "parkDetail";
	}

	
	
}
