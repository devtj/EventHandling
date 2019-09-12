package com.cs.EventDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cs.model.EventLog;
import com.cs.utils.DBManager;

public class EventDao implements EventDaoImpl{
	
	private static final Logger LOGGER = LogManager.getLogger(EventDao.class);
	
	DBManager manager=new DBManager();
	String eventSql="insert into EVENT_LOGGING(EventId , EventDuration, EventAlert , TYPE, HOST) values(?,?,?,?,?)";
	String createSql="CREATE TABLE IF NOT EXISTS EVENT_LOGGING (EventId VARCHAR(100) NOT NULL, EventDuration INTEGER, EventAlert Boolean, TYPE VARCHAR(50), HOST VARCHAR(50))";
	
	//Create table if not existing
	public void createTable() throws SQLException{
		
		try(Connection con=manager.getDBConn();
				Statement stmt	=con.createStatement()) {			
					 	        
	       stmt.executeUpdate(createSql);
		}catch(Exception e) {
			LOGGER.error("Exception while creating table" );
			throw new SQLException();
		}
		
	}
	
	//Insert Event details in Table
	public Integer insertEvent(List<EventLog> eventLogDetails ) throws SQLException{
		 int result[];
		 int lenghtofdata=0;
		try(Connection con=manager.getDBConn();
				PreparedStatement stmt	=con.prepareStatement(eventSql)) {
						
			for(EventLog eventDetails: eventLogDetails) {
				stmt.setString(1,eventDetails.getId());
				stmt.setLong(2, eventDetails.getDuration());
				stmt.setBoolean(3, eventDetails.getAlert());
				stmt.setString(4, eventDetails.getType());
				stmt.setString(5, eventDetails.getHost());
				stmt.addBatch();
			}
			  result = stmt.executeBatch();
			  if(result!=null) {
				  lenghtofdata=result.length;  
			  }
		}catch(Exception e) {
			LOGGER.error("Exception while inserting data" );
			throw new SQLException();
		}
		return lenghtofdata;
	}
	

}
