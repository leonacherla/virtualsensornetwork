package com.vsn.Sensors;

public class HS001 extends Thread {

	public static int data;
	
	public HS001(){
		data = 24;
		Thread t = new Thread();
		t.start();
	}
	
	@Override
	public void run(){
		
		while(true){
			try{
				Thread.sleep(1000);
				data = (int) Math.floor(Math.random()*101);
				System.out.println(data);
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
