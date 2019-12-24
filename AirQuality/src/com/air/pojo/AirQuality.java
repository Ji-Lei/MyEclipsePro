package com.air.pojo;

public class AirQuality {
	private String monitorTime;
	private int pm10;
	private int pm25;
	private String monitoringStation;
	public AirQuality() {
	}
	public AirQuality(String monitorTime, int pm10, int pm25, String monitoringStation) {
		this.monitorTime = monitorTime;
		this.pm10 = pm10;
		this.pm25 = pm25;
		this.monitoringStation = monitoringStation;
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
