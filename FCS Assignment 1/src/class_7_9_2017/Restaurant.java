package class_7_9_2017;

import java.util.Comparator;

public class Restaurant implements Comparator<Restaurant>{
	private String name;
	private double lat;
	private double lon;
	public Restaurant() {
		super();
	}

	private int rating;
	private double distance;
	
	public Restaurant(String name, double lat, double lon, int rating) {
		super();
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int compare(Restaurant o1, Restaurant o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getDistance()-o2.getDistance());
	}
	

}
