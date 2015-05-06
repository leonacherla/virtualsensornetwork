package com.vsn.Sensors;

public class TS001 extends Thread {

public static double data;
	
	public TS001(){
		Thread t = new Thread();
		t.start();
	}
	
	@Override
	public void run(){
		
		while(true){
			try{
				Thread.sleep(1000);
				data = data + (0.1*data);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println("Start of Execution.");
		HS001 obj = new HS001();
		obj.start();
		System.out.println("End of Execution."+ obj);
	}
	
}
