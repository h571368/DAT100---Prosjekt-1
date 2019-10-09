package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double[gpspoints.length];
		
		int i = 0;
		while(i <= gpspoints.length-1) {
		latitudes[i] = gpspoints[i].getLatitude();
		i++;
		}
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double[gpspoints.length];
		int i = 0;
		
		while(i <= gpspoints.length-1) {
		longitudes[i] = gpspoints[i].getLongitude();
		i++;
		}
		return longitudes;
	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d, dlon, dlat,a,c;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();
		
		latitude1 = Math.toRadians(latitude1);
		latitude2 = Math.toRadians(latitude2);
		
		
		dlon = longitude2 - longitude1;
		dlon = Math.toRadians(dlon);
		dlat = latitude2 - latitude1;
		//dlat = Math.toRadians(dlat);
		a = pow(sin(dlat/2),2)+ cos(latitude1) * cos(latitude2) * pow(sin(dlon/2),2);
		c = 2 * atan2( sqrt(a), sqrt(1-a) );
		d = R * c;
		
		
	    return d;

	}
	


	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs = 10;
		double speed, distance;

		distance = distance(gpspoint1, gpspoint2);
		 
		speed = distance/secs;
		speed = speed * 3.6;
		
		return speed;

	}

	public static String formatTime(int secs) {

		int hour = secs / 3600;
		int sec = secs % 3600;
				
		String h = "";
		if (hour <= 10) {
		h = "0";
		}
				
		int min = sec / 60;
		sec = sec % 60;
				
		String m = "";
		if (min <= 10) {
		m = "0";
		}
				
		String s = "";
		if (sec <= 10) {
		s = "0";
		}
			
		String TIMESEP = ":";
		String str = h + hour + TIMESEP + m + min + TIMESEP + s + sec;
				
		StringBuffer buf = new StringBuffer(str);

		while (buf.length() < 10) {
		buf.insert(0, ' ');
		}
				  
		return buf.toString();
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = String.format("%.2f", d);

		StringBuffer buf = new StringBuffer(str);

		while (buf.length() < TEXTWIDTH) {
		  buf.insert(0, ' ');
		}
		
		return buf.toString();
		
	}
}
