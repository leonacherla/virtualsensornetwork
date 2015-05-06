package com.vsn.SensorDataExchange;

import java.util.HashMap;
import java.util.Map;

public class VirtualSensor extends Thread{
	
	public String data;
	public String sensorName;
	public int dataInterval;
	public String sensorState;
	public String Location;
	public String dataFormat;
	public Map<String,String> records;
	
	public void newVirtualSensor(VirtualSensor vs){
		this.data = vs.data;
		this.dataFormat = vs.dataFormat;
		this.dataInterval = vs.dataInterval;
		this.Location = vs.Location;
		this.sensorState = vs.sensorState;
		this.sensorName = vs.sensorName;
		this.records = vs.records;
		
	}
	
	public void persistSensorReadings(String email, VirtualSensor vs){
		Map<String,String> m = new HashMap<String,String>();
		
		//CacheManager cm = new CacheManager();
		//m = cm.getAllDetailsOfUsers(email);
		//String UID = System.currentTime;
		//Write to DB;
		
		m.put("data", vs.data);
		m.put("dataInterval", Integer.toString(vs.dataInterval));
		m.put("sensorState", vs.sensorState);
		m.put("location", vs.Location);
		m.put("dataFormat", vs.dataFormat);
		m.put("sensorName", vs.sensorName);	
	}
	
	public VirtualSensor getDetails(){
		return this;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public int getDataInterval() {
		return dataInterval;
	}

	public void setDataInterval(int dataInterval) {
		this.dataInterval = dataInterval;
	}

	public void setState(String state) {
		sensorState = state;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getDataFormat() {
		return dataFormat;
	}
	
	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	public Map<String, String> getRecords() {
		return records;
	}
	
	public String getSensorState(){
		return sensorState;
	}
	
	public void setRecords(Map<String, String> records) {
		this.records = records;
	}

	@Override
	public void run(){
		
	}
}
