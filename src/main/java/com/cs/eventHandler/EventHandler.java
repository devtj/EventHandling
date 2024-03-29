/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.cs.eventHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cs.model.Event;
import com.cs.model.EventLog;
import com.cs.utils.EventFailureException;
import com.cs.utils.EventUtility;

/*
 * This class contains  application main method. It does below 
 * 1. Read input file 
 * 2. Sorts the file in order of EventId and Start-Finish Sequence 
 * 3. It calls service class which in turn calls database to insert event duration details.
 */

public class EventHandler {

	private static final Logger LOGGER = LogManager.getLogger(EventHandler.class);
	
	public static void main(String args[]) {
				
		LOGGER.info("*********Staring Log Event Application :::::::" + System.currentTimeMillis() + " **********");
		try {
			
			List<Event> eventList = EventUtility.readJsonToList(args[0]);
			List<EventLog> logList;
			Collections.sort(eventList);
			if (eventList != null && eventList.size() > 0) {
				EventHandlerService handlerService = new EventHandlerService();
				logList = handlerService.getLogDetails(eventList);
				if (logList != null && logList.size() > 0) {
					LOGGER.info("Successfully Added Data to Database");
				} else {
					LOGGER.info("Incorrect data for processing.Recheck file");
				}
			} else {
				LOGGER.info("No Data found in file" + args[0]);
			}
			LOGGER.info("*********End Log Event Application :::::::" + System.currentTimeMillis() + " **********");
		} catch (SQLException | EventFailureException ex) {
			LOGGER.error("Exception in Main method :" , ex);
		} 

	}

}
