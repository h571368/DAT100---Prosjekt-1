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

		
		double totalElevation = 0;
		double[] Elevations = GPSUtils.getElevations(gpspoints);
		
		int i = 1;
		while(i <= gpspoints.length-1) {
			
		double deltaElevation = Elevations[i] - Elevations[i-1];
		
		if (deltaElevation > 0) {
			totalElevation += deltaElevation;
			}
		
		i++;
		}
		
		return totalElevation;
	}

	
	public int totalTime() {

		int[] times = GPSUtils.getTimes(gpspoints);
		int totaltime = 0;
		int i = 1;
		while(i < gpspoints.length) {
		totaltime += times[i]- times[i-1];
		i++;
		}
		return totaltime;
	}
	
	public void climbs() {
		
		//WIP climb in percentage
		double[] climbs = new double[gpspoints.length-1];
		double[] Elevations = GPSUtils.getElevations(gpspoints);
			
		int i = 1;
		while(i < gpspoints.length) {
		double distance = GPSUtils.distance(gpspoints[i-1],gpspoints[i]);
		double elevation = Elevations[i];
		climbs[i-1] = elevation/ distance *100;
		i++;
		}
	}
		

	public double[] speeds() {
		
		double[] speeds = new double[gpspoints.length-1];
			
		int i = 1;
		while(i < gpspoints.length) {
			
		speeds[i-1] = GPSUtils.speed(gpspoints[i-1],gpspoints[i]);
		i++;
		}
		
		return speeds;

	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		maxspeed = GPSUtils.findMax(speeds());
		return maxspeed;
	}

	public double averageSpeed() {

		double average = 0;
	  
	    double dist = totalDistance();
	    double time = totalTime();
	    
	    average = (dist/time)*3.6;
	    
		return average;
		
	}
	// conversion factor m/s to miles per hour
	public static double MS = 2.23693629;

	// beregn kcal gitt weight og tid der kjoeres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {
		
		double kcal = 0;
		
		double met = 0;
		double speedmph = speed * MS;
		
		
		double [] Speeds = new double[] {
				0, 10, 12,  14,  16, 20, Integer.MAX_VALUE
		};
		
		double [] METs = new double[] {
				0, 4.0, 6.0, 8.0, 10.0, 12.0, 16.0 
		};
		
		for (int i = 0; i < Speeds.length; i++) {
			if(speedmph >= Speeds[i]) {
				met = METs[i + 1];
			}
		}
		
		kcal = met * weight * secs/ (60.0 * 60.0);
		
		
		return kcal;
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;
		double[] Speeds = speeds();
		int[] Times = GPSUtils.getTimes(gpspoints);
		
		for	(int i = 0; i < Speeds.length; i++) {
		totalkcal += kcal(weight, (Times[i+1] - Times[i]), Speeds[i]);
		}
			
		return totalkcal;

		
	}
	
	private static double WEIGHT = 80.0;

	
	public String[] displayStatistics() {
		
		String[] statistics = new String[6];
		statistics[0] = "Total time------------" + GPSUtils.formatTime(totalTime());
		statistics[1] = "Total distance--------" + GPSUtils.formatDouble((totalDistance()/1000))+" km";
		statistics[2] = "Total elevation-------" + GPSUtils.formatDouble(totalElevation())+" m";
		statistics[3] =	"Max speed-------------" + GPSUtils.formatDouble(maxSpeed())+" km/t";
		statistics[4] = "Average speed---------" + GPSUtils.formatDouble(averageSpeed())+" km/t";
		statistics[5] = "Energy----------------" + GPSUtils.formatDouble(totalKcal(WEIGHT)) +" kcal";
				
				
		System.out.println("==============================================");
		
		System.out.println(statistics[0]);
		System.out.println(statistics[1]);
		System.out.println(statistics[2]);
		System.out.println(statistics[3]);
		System.out.println(statistics[4]);
		System.out.println(statistics[5]);
		
		System.out.println("==============================================");
		
		return statistics;
		// TODO - SLUTT
		
	}

}
