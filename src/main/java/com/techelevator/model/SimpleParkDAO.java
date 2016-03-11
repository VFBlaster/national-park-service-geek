package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class SimpleParkDAO implements ParkDAO{
	
	private List<Park> parkList;
	
	public SimpleParkDAO() {
		
		parkList = new ArrayList<Park>();
		
		Park park = new Park("GNP");
		park.setName("Glacier National Park");
		park.setDescription("Lorem ipsum dolor sit amet, amet wisi arcu suspendisse, dolor risus est sodales sociis arcu vel, orci sed magna adipiscing massa interdum. Fermentum rutrum nullam hac, nam sodales eleifend pede a, vel ridiculus cursus varius faucibus in in, dapibus integer nobis sem. Mauris ullam");
		park.setLocation("Montana");
		park.setAcreage ("10000");
		park.setElevation ("13000");
		park.setMilesOfTrail("100");
		park.setNumberOfCampsites("20");
		park.setYearFounded ("1985");
		park.setClimate ("mild");
		park.setAnnualVisitorCount ("20000");
		park.setQuote("Beautiful Park");
		park.setQuoteSource("John Muir");
		park.setEntryFee("$3.00");
		park.setNumberOfSpecies("126");
		parkList.add(park);
		
		park = new Park("GCNP");
		park.setName("Grand Canyon National Park");
		park.setDescription("Lorem ipsum dolor sit amet, amet wisi arcu suspendisse, dolor risus est sodales sociis arcu vel, orci sed magna adipiscing massa interdum. Fermentum rutrum nullam hac, nam sodales eleifend pede a, vel ridiculus cursus varius faucibus in in, dapibus integer nobis sem. Mauris ullam");
		park.setLocation("Arizona");
		park.setAcreage ("12000");
		park.setElevation ("13000");
		park.setMilesOfTrail("100");
		park.setNumberOfCampsites("20");
		park.setYearFounded ("1985");
		park.setClimate ("mild");
		park.setAnnualVisitorCount ("20000");
		parkList.add(park);
		
		park = new Park("CVNP");
		park.setName("Cuyahoga Valley National Park");
		park.setDescription("Lorem ipsum dolor sit amet, amet wisi arcu suspendisse, dolor risus est sodales sociis arcu vel, orci sed magna adipiscing massa interdum. Fermentum rutrum nullam hac, nam sodales eleifend pede a, vel ridiculus cursus varius faucibus in in, dapibus integer nobis sem. Mauris ullam");
		park.setLocation("Ohio");
		park.setAcreage ("10000");
		park.setElevation ("13000");
		park.setMilesOfTrail("100");
		park.setNumberOfCampsites("20");
		park.setYearFounded ("1985");
		park.setClimate ("mild");
		park.setAnnualVisitorCount ("20000");
		parkList.add(park);
	}
	
	
	@Override
	public List<Park> readAllParks() {
		return parkList;
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
