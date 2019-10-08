package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int secs, hr, min, sec;
		
		String deling = timestr.split("T")[1];
		hr = Integer.parseInt(deling.split(":")[0]);
		min = Integer.parseInt(deling.split(":")[1]);
		double sek = Double.parseDouble(deling.split(":")[2]);
		sec = (int) sek;
		
		//throw new UnsupportedOperationException(TODO.method());

		secs = hr*60*60 + min*60 + sec;
		
		return secs;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO - START ;
		
		throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT ;
	    
	}
	
}
