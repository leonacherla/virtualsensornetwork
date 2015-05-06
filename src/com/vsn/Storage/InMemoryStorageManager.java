package com.vsn.Storage;
import java.util.HashMap;
import java.util.Map;

import com.vsn.SensorDataExchange.VirtualSensor;

public class InMemoryStorageManager {

	public static Map<String, VirtualSensor> users = new HashMap<String, VirtualSensor>();

	public Map<String, VirtualSensor> getUsers() {
		return users;
	}

	public void setUsers(Map<String, VirtualSensor> users) {
		InMemoryStorageManager.users = users;
	}
	
	public VirtualSensor retrieveUserSensor(String email){
		return users.get(email);
	}
	
	public void editUserSensorDetails(String email, VirtualSensor vs){
		InMemoryStorageManager.users.put(email, vs);
	}
	
}
