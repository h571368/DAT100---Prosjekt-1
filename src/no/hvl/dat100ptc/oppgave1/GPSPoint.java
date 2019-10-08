package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	private int time;
	private double latitude, longitude, elevation;
		
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		// TODO - konstruktur
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;

		//throw new UnsupportedOperationException(TODO.construtor("GPSPoint"));

	}

	// TODO - get/set metoder
	public int getTime() {
		
		//throw new UnsupportedOperationException(TODO.method());
		return time;
		
	}

	public void setTime(int time) {
		
		this.time = time;
		//throw new UnsupportedOperationException(TODO.method());

	}

	public double getLatitude() {
		
		//throw new UnsupportedOperationException(TODO.method());
		return latitude;
		
	}

	public void setLatitude(double latitude) {
		
		this.latitude = latitude;
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public double getLongitude() {
		
		//throw new UnsupportedOperationException(TODO.method());
		return longitude;
	}

	public void setLongitude(double longitude) {
		
		this.longitude = longitude;
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public double getElevation() {
		
		//throw new UnsupportedOperationException(TODO.method());
		return elevation;
	}

	public void setElevation(double elevation) {
		
		this.elevation = elevation;
		//throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public String toString() {
		
		// TODO - start
		String str = Integer.toString(time) + " (" + Double.toString(latitude) + "," 
		+ Double.toString(longitude) + ") " + Double.toString(elevation);

		//throw new UnsupportedOperationException(TODO.method());
		
		return str;
		// TODO - slutt
		
	}
}
