package com.air.pojo;

public class Air {
	private int id;
	private String name;
	private String monitorTime;
	private int pm10;
	private int pm25;
	private String monitoringStation;
	
	public Air() {
	}
	public Air(String name, String monitorTime, int pm10, int pm25, String monitoringStation) {
		this.name = name;
		this.monitorTime = monitorTime;
		this.pm10 = pm10;
		this.pm25 = pm25;
		this.monitoringStation = monitoringStation;
	}
	public Air(int id, String name, String monitorTime, int pm10, int pm25, String monitoringStation) {
		this.id = id;
		this.name = name;
		this.monitorTime = monitorTime;
		this.pm10 = pm10;
		this.pm25 = pm25;
		this.monitoringStation = monitoringStation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMonitorTime() {
		return monitorTime;
	}
	public void setMonitorTime(String monitorTime) {
		this.monitorTime = monitorTime;
	}
	public int getPm10() {
		return pm10;
	}
	public void setPm10(int pm10) {
		this.pm10 = pm10;
	}
	public int getPm25() {
		return pm25;
	}
	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}
	public String getMonitoringStation() {
		return monitoringStation;
	}
	public void setMonitoringStation(String monitoringStation) {
		this.monitoringStation = monitoringStation;
	}
	
	
}
