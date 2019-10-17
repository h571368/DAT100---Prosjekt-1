package no.hvl.dat100ptc.oppgave6;

import javax.swing.JOptionPane;

import easygraphics.*;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class CycleComputer extends EasyGraphics {

	private static int[] times;
	private static double[] speeds;
	private static double[] latitudes;
	private static double[] longitudes;
	private static double[] elevations;
	
	private static int SPACE = 10;
	private static int MARGIN = 20;
	
	// FIXME: take into account number of measurements / gps points
	private static int ROUTEMAPXSIZE = 800; 
	private static int ROUTEMAPYSIZE = 400; 
	private static int HEIGHTSIZE = 200;
	private static int TEXTWIDTH = 200;
	

	private GPSComputer gpscomp;
	private GPSPoint[] gpspoints;
	
	private int N = 0;

	private double minlon, minlat, maxlon, maxlat;

	private double xstep, ystep;

	public CycleComputer() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");

		gpscomp = new GPSComputer(filename);
		gpspoints = gpscomp.getGPSPoints();
		speeds = gpscomp.speeds();
		times = GPSUtils.getTimes(gpspoints);
		latitudes = GPSUtils.getLatitudes(gpspoints);
		longitudes = GPSUtils.getLongitudes(gpspoints);
		elevations = GPSUtils.getElevations(gpspoints);

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		N = gpspoints.length; // number of gps points

		minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));

		xstep = xstep();
		ystep = ystep();

		makeWindow("Cycle Computer", 
				2 * MARGIN + ROUTEMAPXSIZE,
				2 * MARGIN + ROUTEMAPYSIZE + HEIGHTSIZE + SPACE);

		bikeRoute();

	}

	
	public void bikeRoute() {

		int ybase = MARGIN + ROUTEMAPYSIZE;
		double xstep = xstep();
		double ystep = ystep();

		double minlon = GPSUtils.findMin(longitudes);
		double minlat = GPSUtils.findMin(latitudes);

		setColor(0, 255, 0); // green

		// draw the locations
		
		int lastX = 0;
		int lastY = 0;
		for (int i = 0; i < latitudes.length; i++) {

			int x,y;

			
			x = MARGIN + (int) ((longitudes[i] - minlon) * xstep);
			y = ybase - (int) ((latitudes[i] - minlat) * ystep);
			
			fillCircle(x,y,3);
			
			if(i > 0) {
				drawLine(lastX, lastY, x, y);
			}
			lastX = x;
			lastY = y;
		}
		
	}


	public double xstep() {

		double maxlon = GPSUtils.findMax(longitudes);
		double minlon = GPSUtils.findMin(longitudes);

		double xstep = ROUTEMAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	public double ystep() {

		double maxlat = GPSUtils.findMax(latitudes);
		double minlat = GPSUtils.findMin(latitudes);

		double ystep = ROUTEMAPXSIZE / (Math.abs(maxlat - minlat)); 
		
		// OPPGAVE SLUTT
		
		return ystep;
	}

}
