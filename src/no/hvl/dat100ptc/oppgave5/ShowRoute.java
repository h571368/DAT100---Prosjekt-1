package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static final long serialVersionUID = 1L;

	private static int[] times;
	private static double[] speeds;
	private static double[] latitudes;
	private static double[] longitudes;
	private static double[] elevations;
	private static String[] statistics;

	private static int MARGIN = 50;
	private static int MAPXSIZE = 600;
	private static int MAPYSIZE = 600;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;

	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

		statistics = gpscomputer.displayStatistics();
		speeds = gpscomputer.speeds();
		times = GPSUtils.getTimes(gpspoints);
		latitudes = GPSUtils.getLatitudes(gpspoints);
		longitudes = GPSUtils.getLongitudes(gpspoints);
		elevations = GPSUtils.getElevations(gpspoints);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		playRoute(MARGIN + MAPYSIZE);

		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(longitudes);
		double minlon = GPSUtils.findMin(longitudes);																													// ----------

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon));

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {

		double maxlat = GPSUtils.findMax(latitudes);
		double minlat = GPSUtils.findMin(latitudes);

		double ystep = MAPXSIZE / (Math.abs(maxlat - minlat));

		return ystep;
	}

	public void showRouteMap(int ybase) {

		double xstep = xstep();
		double ystep = ystep();

		double step = xstep;
		if (xstep < ystep) {
			step = ystep;
		}

		double minlon = GPSUtils.findMin(longitudes);
		double minlat = GPSUtils.findMin(latitudes);

		setColor(0, 255, 0); // green

		int lastX = 0;
		int lastY = 0;

		for (int i = 0; i < gpspoints.length; i++) {

			GPSPoint point = gpspoints[i];
			double longitude = point.getLongitude();
			double latitude = point.getLatitude();

			int xAxis = MARGIN + (int) (Math.abs(longitude - minlon) * xstep);
			int yAxis = ybase - (int) (Math.abs(latitude - minlat) * ystep);

			if (lastX == 0) {
				lastX = xAxis;
			}
			if (lastY == 0) {
				lastY = yAxis;
			}
			fillCircle(xAxis, yAxis, 4);
			drawLine(lastX, lastY, xAxis, yAxis);

			lastX = xAxis;
			lastY = yAxis;
		}
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0, 0, 0);
		setFont("Arial", 12);

		for (int i = 0; i < statistics.length; i++) {
			drawString(statistics[i], TEXTDISTANCE, TEXTDISTANCE * (i + 1));
		}
	}

	public void playRoute(int ybase) {
		
		double minlon = GPSUtils.findMin(longitudes);
		double minlat = GPSUtils.findMin(latitudes);
		
		double ystep = ystep();
		double xstep = xstep();

		int xAxis= MARGIN + (int) (Math.abs(gpspoints[0].getLongitude() - minlon) * xstep);
		int yAxis = ybase - (int) (Math.abs(gpspoints[0].getLatitude() - minlat) * ystep);
		
		setColor(0, 0, 255);
		setSpeed(1);
		int cId = fillCircle(xAxis, yAxis, 5);
		
		for (int i = 0; i < gpspoints.length; i++) {

			double longitude = gpspoints[i].getLongitude();
			double latitude = gpspoints[i].getLatitude();

			int xAxisAnim = MARGIN + (int) (Math.abs(longitude - minlon) * xstep);
			int yAxisAnim = ybase - (int) (Math.abs(latitude - minlat) * ystep);
			
			moveCircle(cId, xAxisAnim, yAxisAnim);
		}
	}

}
