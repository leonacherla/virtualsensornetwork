package com.vsn.SensorState;

import java.util.HashMap;
import java.util.Map;

import com.vsn.SensorDataExchange.VirtualSensor;
import com.vsn.Sensors.HS001;
import com.vsn.Sensors.PS001;
import com.vsn.Sensors.TS001;
import com.vsn.Storage.CacheManager;

public class ScheduledState extends Thread{

	String data;
	int dataInterval;
	String sensorState;
	String sensorName;
	String userEmail;
	
	public ScheduledState(String email,VirtualSensor vs){
		this.data = vs.data;
		this.dataInterval = vs.dataInterval;
		this.sensorName = vs.sensorName;
		this.sensorState = vs.sensorState;
	}
	
	public void persistData(){
		CacheManager cm = new CacheManager();
		Map<String,String> m = new HashMap<String,String>();
		m.put(Long.toString(System.currentTimeMillis()), data);
		cm.saveSensorData(userEmail, sensorName, m);
	}
	
	@Override
	public void run(){
		try{
			while(!sensorState.equalsIgnoreCase("stop")){
				if(sensorName == "HS001"){
					data = Integer.toString(HS001.data);	
				}
				else if(sensorName == "PS001"){
					data = Integer.toString(PS001.data);
				}
				else if(sensorName == "TS001"){
					data = Double.toString(TS001.data);
				}
				persistData();
				Thread.sleep(dataInterval);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
