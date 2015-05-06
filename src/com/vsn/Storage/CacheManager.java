package com.vsn.Storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class CacheManager {

	Jedis j;
	
	public CacheManager(){
		j = new Jedis("localhost");
	}
	
	public void registerUser(String email, String password, String name){
		
		Map<String,String> m = new HashMap<String,String>();
		m.put("password", password);
		m.put("name", name);
		j.hmset(email, m);
	}
	
	public boolean login(String email, String password){
		boolean result = false;
		System.out.println(email +" "+password);
		List<String> val = j.hmget(email, "password");
		System.out.println("From Cache: "+val.get(0));
		if(!val.isEmpty()){
			if(password.toString().compareTo(val.get(0).toString())==0){
				return true;
			}
			else
			{System.out.println("reaches here");return false;}
			
		}
		return result;
	}
	
	public boolean changePassword(String email, String password, String newPassword){
		boolean result = false;
		System.out.println(email +" "+password);
		Map<String,String> m = j.hgetAll(email);
		List<String> val = j.hmget(email, "password");
		System.out.println("From Cache: "+val.get(0));
		if(!val.isEmpty()){
			if(password.toString().compareTo(val.get(0).toString())==0){
				m.put("password", newPassword);
				return true;
			}
			else{
				System.out.println("reaches here");return false;
			}
		}
		return result;
	}
	
	public Map<String,String> returnUserPreferences(String email){
		Map<String,String> m = j.hgetAll(email);
		return m;
	}
	
	public void saveUserPreferences(String email, Map<String,String> m){
		j.hmset(email, m);
	}
	
	
	public void saveSensorData(String email, String sensorName, Map<String,String> m){
		j.hmset(email+sensorName, m);
	}
}
