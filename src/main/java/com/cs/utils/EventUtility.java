package com.cs.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cs.eventHandler.EventHandler;
import com.cs.model.Event;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventUtility {

	/*
	 * This method reads Json String and map it to EVENT Pojo. 
	 * All the information in file is stored in a ArrayList.
	 */
	private static final Logger LOGGER = LogManager.getLogger(EventUtility.class);
	
	public static List<Event> readJsonToList(String file) {

		List<Event> eventList = new ArrayList<Event>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String jsonString = reader.readLine();
			LOGGER.info("Input File: "+ file  + " reading started");
			while (jsonString != null) {
				Event event = new ObjectMapper().readValue(jsonString, Event.class);
				eventList.add(event);
				jsonString = reader.readLine();
			}
			LOGGER.info("Input File: "+ file + " reading completed");

		} catch (FileNotFoundException e) {
			LOGGER.error("Input file is not found" , e);
		}catch(JsonParseException e) {
			LOGGER.error("Exception in parsing File.Each line should contain data in JSON Format with one line representing as one Event" , e);
		}catch (Exception e) {
			LOGGER.error("Exception in readJsonToList() method" , e);
		}
		return eventList;

	}
	
	
	//Difference between start and finish time of an event in seconds
	public static long calculateDuration(Timestamp t1,Timestamp t2) {
		long duration=0;
		
		if (t1!=null && t2!=null) {				
			duration= (t2.getTime()-t1.getTime())/1000;				
		}
		return duration;
	}
}
