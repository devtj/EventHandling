package com.cs.model;


public class EventLog {
	
	private String id;
	private long duration;
	private String type;
	private String host;
	private Boolean Alert;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
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
	
	public Boolean getAlert() {
		return Alert;
	}
	public void setAlert(Boolean alert) {
		Alert = alert;
	}
	@Override
	public String toString() {
		return "EventLog [id=" + id + ", duration=" + duration + ", type=" + type + ", host=" + host + ", Alert="
				+ Alert + "]";
	}
	
	
   }
	
