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
		
		int secs;
		int hr, min, sec;
		
		// TODO
		// OPPGAVE - START
		
		hr = Integer.parseInt(timestr.substring(11, 13));
		
		min = Integer.parseInt(timestr.substring(14, 16));
		
		sec = Integer.parseInt(timestr.substring(17,19));
		
		secs = sec + min * 60 + hr* 3600;
		
		return secs;
		// OPPGAVE - SLUTT
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO - START ;
		int Time = toSeconds(timeStr);
		double Latitude = Double.parseDouble(latitudeStr);
		double Longitude = Double.parseDouble(longitudeStr);
		double Elevation = Double.parseDouble(elevationStr);
		gpspoint = new GPSPoint(Time, Latitude, Longitude, Elevation);
		
		return gpspoint;
		

		// OPPGAVE - SLUTT ;
	    
	}
	
}
