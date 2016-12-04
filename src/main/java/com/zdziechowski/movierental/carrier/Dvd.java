package com.zdziechowski.movierental.carrier;

final public class Dvd implements Carrier {
	private String releaseYear;
	private String category;
	private boolean available = true; // when true - available, false - loaned

    public Dvd(String releaseYear, String category) {
        this.releaseYear = releaseYear;
    	this.category = category;
		this.available = true;
	}

	public Dvd() {
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean status) {
		this.available = status;
	}

	public String getCarrier() {
		return "dvd";
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
}
