package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowSpeed extends EasyGraphics {
			
	private static int MARGIN = 50;
	private static int BARHEIGHT = 200; // assume no speed above 200 km/t

	private static double[] speeds;
	
	private GPSComputer gpscomputer;
	private GPSPoint[] gpspoints;
	
	public ShowSpeed() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);
		
		gpspoints = gpscomputer.getGPSPoints();
		speeds = gpscomputer.speeds();
	}
	
	// read in the files and draw into using EasyGraphics
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length-1; // number of data points // Why -1?
		
		makeWindow("Speed profile", 2*MARGIN + 2 * N, 2 * MARGIN + BARHEIGHT);
		
		showSpeedProfile(MARGIN + BARHEIGHT,N);
	}
	
	public void showSpeedProfile(int ybase, int N) {
		
		System.out.println("Angi tidsskalering i tegnevinduet ...");
		int timescaling = Integer.parseInt(getText("Tidsskalering"));
		
		int avarageSpeed = ybase - (int) gpscomputer.averageSpeed();
		int space = 0;
		
		for (int i = 0; i < N; i++){
			 
			setColor(0, 0, 255);
			double[] speedArray = speeds;
			double velocity = speedArray[i];

			if (velocity < 0) {velocity = 0;}

			int startEndPointX = MARGIN + space;
			int startPointY = ybase - (int) velocity;
			space += 2;

			fillRectangle(startEndPointX, startPointY, 1, ybase);
		}
		setColor(0, 255, 0);
		drawLine(MARGIN, avarageSpeed, MARGIN + N*2, avarageSpeed);
	}
}
