package com.zdziechowski.movierental.carrier;

public class Videotape implements Carrier {
	private String releaseYear;
	private String category;
	private boolean available = true; // when true - available, false - loaned

	public Videotape(String releaseYear, String category) {
		this.releaseYear = releaseYear;
		this.category = category;
		this.available = true;
	}

	public Videotape() {
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getCarrier() {
		return "videotape";
	}

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return available;
	}

	@Override
	public void setAvailable(boolean status) {
		// TODO Auto-generated method stub
		this.available = status;
	}
	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

}
