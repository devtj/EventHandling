package com.cs.model;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

public class Event implements Comparable<Event>{
	
	private String id;
	private String state;
	private String type;
	private String host;
	private Timestamp timestamp;
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", state=" + state + ", type=" + type + ", host=" + host + ", timestamp=" + timestamp
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public int compareTo(Event event) {
		int i = id.compareTo(event.id);
		
		if (i==0) {
			
			return (event.state).compareTo(state);
		}
		
		return i;
		
			
	}
		    
   }
	
