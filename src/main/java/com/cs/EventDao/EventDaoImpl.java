package com.cs.EventDao;

import java.sql.SQLException;
import java.util.List;

import com.cs.model.EventLog;

public interface EventDaoImpl {
	
	public void createTable() throws Exception;
	public Integer insertEvent(List<EventLog> eventLogDetails)throws SQLException;

}
