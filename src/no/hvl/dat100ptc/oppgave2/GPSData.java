package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		
		antall = 0;
		gpspoints = new GPSPoint [n];

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START
		
		if(antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		}
		return inserted;

		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;

		// TODO - START
		int Time = GPSDataConverter.toSeconds(time);
		double Latitude = Double.parseDouble(latitude);
		double Longitude = Double.parseDouble(longitude);
		double Elevation = Double.parseDouble(elevation);
		gpspoint = new GPSPoint(Time, Latitude, Longitude, Elevation);
		return insertGPS(gpspoint);
		// TODO - SLUTT
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START
		String str;
		for (GPSPoint v : gpspoints) {
			str = v.toString();
			System.out.print(str);
		}
		
		// TODO - SLUTT
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
