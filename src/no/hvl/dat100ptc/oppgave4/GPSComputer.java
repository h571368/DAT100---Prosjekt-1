package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints = getGPSPoints();
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {
	
		double distance = 0;
		int i = 1;
		while(i <= gpspoints.length-1) {
		GPSPoint A = gpspoints[i-1];
		GPSPoint B = gpspoints[i];	
		distance += GPSUtils.distance(A, B);
		i++;
		}
		return distance;
		}
	
	
	public double totalElevation() {

		double totelevation = 0;
		
		int i = 1;
		while(i <= gpspoints.length-1) {
		GPSPoint A = gpspoints[i-1];
		GPSPoint B = gpspoints[i];
		
		if (i == 1 && A.getElevation()>=0) {
			totelevation = A.getElevation();
		}
		
		if (A.getElevation() < B.getElevation() && B.getElevation()>0) {
		totelevation =+ B.getElevation();
		}
		
		i++;
		}
		return totelevation;
	}

	
	public int totalTime() {

		int totaltime = 0;
		int i = 1;
		while(i < gpspoints.length) {
		totaltime += gpspoints[i].getTime()-gpspoints[i-1].getTime();
		i++;
		}
		return totaltime;
	}
		

	public double[] speeds() {
		
		double speed = 0;
		double[] speeds = new double[gpspoints.length-1];
			
		int i = 1;
		while(i <= gpspoints.length-1) {
		
		GPSPoint A = gpspoints[i-1];
		GPSPoint B = gpspoints[i];
		
		speed = GPSUtils.speed(A,B);
		speeds[i-1] = speed;
		i++;
		}
		
		return speeds;

	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		double[] allSpeeds = speeds();
		
		int i = 0;
		while(i < allSpeeds.length) {
		
		if (allSpeeds[i] > maxspeed) {
		maxspeed = allSpeeds[i];
		}
		
		i++;
		
		}
		return maxspeed;
		
	}

	public double averageSpeed() {

		double average = 0;
		
		double[] allspeeds = speeds();
		
		double sum = 0;
	    for (double value : allspeeds) {
	        sum += value;
	    }
	    average = sum/allspeeds.length;
		
		
		/*GPSPoint[] GPSspeeds = getGPSPoints();
		double speed = 0;
			
		int i = 1;
		while(i <= GPSspeeds.length-1) {
		
		GPSPoint A = GPSspeeds[i-1];
		GPSPoint B = GPSspeeds[i];
		
		speed = GPSUtils.speed(A,B);
		average += speed;
		i++;
		}
		
		average /= GPSspeeds.length-1;*/
		
		return average;
		
	}
	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {
		
		double fart = speed/0.62;
		double vekt = weight;
		int sekunder = secs;
		double kcal = 0;
		
		if (fart >= 32) {
			kcal = 16 * vekt * sekunder/3600;
		}
		else if (fart >= 26) {
			kcal = 12 * vekt * sekunder/3600;
		}
		else if (fart >= 22.5) {
			kcal = 10 * vekt * sekunder/3600;
		}
		else if (fart >= 19) {
			kcal = 8 * vekt * sekunder/3600;
		}
		else if (fart >= 16) {
			kcal = 6 * vekt * sekunder/3600;
		}
		else if (fart < 16) {
			kcal = 4 * vekt * sekunder/3600;
		}
		
		return kcal;
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;
		
		
		
		throw new UnsupportedOperationException(TODO.method());

		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		System.out.println("==============================================");

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	}

}
