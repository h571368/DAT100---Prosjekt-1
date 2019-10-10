package no.hvl.dat100ptc.oppgave5;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import javax.swing.JOptionPane;

public class ShowProfile extends EasyGraphics {

	private static int MARGIN = 50;		// margin on the sides 
	
	//FIXME: use highest point and scale accordingly
	private static int MAXBARHEIGHT = 500; // assume no height above 500 meters
	
	private GPSPoint[] gpspoints;

	public ShowProfile() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		GPSComputer gpscomputer =  new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length; // number of data points

		makeWindow("Height profile", 2 * MARGIN + 3 * N, 2 * MARGIN + MAXBARHEIGHT);

		// top margin + height of drawing area
		showHeightProfile(MARGIN + MAXBARHEIGHT); 
	}

	public void showHeightProfile(int ybase) {
		
		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());
		int arrayLength = gpspoints.length;
		if (arrayLength > 500) {
			arrayLength = 500;
			System.out.println("Length of array is bigger than 500, and too big to show.");
		}


		for (int i = 0; i < arrayLength; i++){

			GPSPoint point = gpspoints[i];
			double height = point.getElevation();

			int startEndPointX = MARGIN + i;
			int startPointY = ybase - (int) height;
			int endPointY = MARGIN + MAXBARHEIGHT;

		drawLine(startEndPointX, startPointY, startEndPointX, endPointY);
		}
	
		// TODO - SLUTT
	}

}