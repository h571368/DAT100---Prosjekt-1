package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
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

		// TODO - START
		double[] latitudes = new double[gpspoints.length];
		int i = 0;
		while(i < gpspoints.length) {
		latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] longitudes = new double[gpspoints.length];
		int i = 0;
		while(i < gpspoints.length) {
		longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		// TODO - START
		
		double d, dlon, dlat,a,c;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();
		
		dlon = longitude2 - longitude1;
		dlat = latitude2 - latitude1;
		a = pow(sin(dlat/2),2)+ cos(latitude1) * cos(latitude2) * pow(sin(dlon/2),2);
		c = 2 * atan2( sqrt(a), sqrt(1-a) );
		d = R * c;
		
		return d;

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs = 0; // Hvor kommer tiden fra????
		double speed, distance;

		distance = distance(gpspoint1,gpspoint2);
		
		speed = distance/secs;
		
		return speed;



		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
}
