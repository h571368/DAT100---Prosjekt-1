package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall;

	public GPSData(int n) {
		antall = 0;

		gpspoints = new GPSPoint[n];
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		}

		return inserted;

	
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		//GPSPoint gpspoint;

		// TODO - START

		int timeInt = Integer.parseInt(time);
		double latitudeDouble = Double.parseDouble(latitude);
		double longitudeDouble = Double.parseDouble(longitude);
		double elevationDouble = Double.parseDouble(elevation);

		GPSPoint p = new GPSPoint(timeInt, latitudeDouble, longitudeDouble, elevationDouble);
		boolean inserted = insertGPS(p);
		
		return inserted;
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		for (GPSPoint i: gpspoints){

			System.out.println(i.toString());

		}
		
		 System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}