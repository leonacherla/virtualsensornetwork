package com.vsn.SensorDataExchange;

import java.util.concurrent.atomic.AtomicReference;

public class SensorProvisionManager {

	protected static AtomicReference<SensorProvisionManager> instance = new AtomicReference<SensorProvisionManager>();
	
	public static SensorProvisionManager init() {
		instance.compareAndSet(null, new SensorProvisionManager());
		return instance.get();
	}
}
