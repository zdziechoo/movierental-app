package com.zdziechowski.movierental.carrier;

public interface Carrier {
	//final String[] CATEGORIES = {"comedy","horror","action","thriller","biography","for children","for teenagers"};

	String getCategory();

	void setCategory(String category);

	String getCarrier();

	boolean isAvailable();

	void setAvailable(boolean status);

	String getReleaseYear();

	void setReleaseYear(String releaseYear);
	
}
