package com.techelevator.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileSystemParkDAO implements ParkDAO{
	
	private List<Park> parkList;
	BufferedReader inputReader;

	public FileSystemParkDAO(InputStream input){
		parkList = new ArrayList<>();
		InputStreamReader reader = new InputStreamReader(input);
		inputReader = new BufferedReader(reader);
		throwAwayHeaderLine();
		String line = readNextLine();
		
		while(line != null){
			String[] fields = line.split("\t");
			Park thePark = new Park(fields[0]);
			thePark.setName(fields[1]);		
			thePark.setLocation(fields[2]);			
			thePark.setAcreage(fields[3]);			
			thePark.setElevation(fields[4]);			
			thePark.setMilesOfTrail(fields[5]);		
			thePark.setNumberOfCampsites(fields[6]);		
			thePark.setClimate(fields[7]);		
			thePark.setYearFounded(fields[8]);		
			thePark.setAnnualVisitorCount(fields[9]);		
			thePark.setQuote(fields[10]);		
			thePark.setQuoteSource(fields[11]);	
			thePark.setDescription(fields[12]);		
			thePark.setEntryFee(fields[13]);			
			thePark.setNumberOfSpecies(fields[14]);
			
			parkList.add(thePark);
			line = readNextLine();
		}
	}
	
	public List<Park> readAllParks(){
		return parkList;
	}

	
	private void throwAwayHeaderLine() {
		readNextLine();
	}

	
	
	private String readNextLine() {
		String parkInfoLine = null;
		try{
			parkInfoLine =inputReader.readLine();
		} catch (IOException e){
		}
		return parkInfoLine;
	}

	
	@Override
	public Park findParkByCode(String parkCode) {
		Park desired = null;
		for (Park p : parkList){
			if(p.getParkCode().equals(parkCode)){
				desired = p;
			}
		}
		return desired;
	}

}
