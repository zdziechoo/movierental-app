package com.zdziechowski.movierental.carrier;

public interface Carrier {
	//final String[] CATEGORIES = {"comedy","horror","action","thriller","biography","for children","for teenagers"};

	String getName();

	void setName(String name);

	String getCategory();

	void setCategory(String category);

	String getCarrier();

	boolean isAvailable();

	void setAvailable(boolean status);
	
}
