package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
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
		
	
			GPSPoint[] GPSTotalDistance = getGPSPoints();
			
			double distance = 0;
			int i = 1;
			while(i <= GPSTotalDistance.length-1) {
			GPSPoint A = GPSTotalDistance[i-1];
			GPSPoint B = GPSTotalDistance[i];	
			distance += GPSUtils.distance(A, B);
			i++;
			}
			return distance;
		}

		//throw new UnsupportedOperationException(TODO.method());

	
	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double totelevation = 0;

		GPSPoint[] GPSTotalElevation = getGPSPoints();
		
		int i = 1;
		while(i <= GPSTotalElevation.length-1) {
		GPSPoint A = GPSTotalElevation[i-1];
		GPSPoint B = GPSTotalElevation[i];
		
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

	

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {

		int totaltime = 0;
		
		GPSPoint[] GPSTotalTime = getGPSPoints();
		
		int i = 1;
		while(i <= GPSTotalTime.length-1) {
		GPSPoint A = GPSTotalTime[i-1];
		GPSPoint B = GPSTotalTime[i];
		
		if (i == 1 ) {
			totaltime = A.getTime();
		}
		totaltime =+ B.getTime();
		i++;
		}
		
		
		
		return totaltime;

	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {
		
		// TODO - START		// OPPGAVE - START
		
		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO - START
		
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	}

	public double averageSpeed() {

		double average = 0;
		
		// TODO - START
		
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

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
