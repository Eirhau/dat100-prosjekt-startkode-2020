package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	// TODO - objektvariable
	private int TIME;
	private double LATITUDE;
	private double LONGITUDE;
	private double ELEVATION;
		
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		// TODO - konstruktur
		TIME = time;
		LATITUDE = latitude;
		LONGITUDE = longitude;
		ELEVATION=elevation;


	}

	// TODO - get/set metoder
	public int getTime() {
		return TIME;
		
	}

	public void setTime(int time) {
		TIME = time;
		
	}

	public double getLatitude() {
		return LATITUDE;
		
	}

	public void setLatitude(double latitude) {
		LATITUDE = latitude;
		
	}

	public double getLongitude() {
		return LONGITUDE;
		
	}

	public void setLongitude(double longitude) {
		LONGITUDE = longitude;
		
	}

	public double getElevation() {
		return ELEVATION;
	}

	public void setElevation(double elevation) {
		ELEVATION= elevation;
		
	}
	
	public String toString() {
		
		String str;
		
		// TODO - start

		str = (TIME + " (" + LATITUDE+","+ LONGITUDE+") "+ ELEVATION + "\n");
		
		return str;
		// TODO - slutt
		
	}
}
