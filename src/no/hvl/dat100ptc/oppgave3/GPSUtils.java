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

		// TODO - START
		min = da[0];
		for (double i : da) {
			if(i < min) {
				min = i;
			}
		}
		return min;
		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double lat[] = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			lat[i] = gpspoints[i].getLatitude();
		}
		return lat;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double lon[] = new double[gpspoints.length];
		int i = 0;
		for (GPSPoint v : gpspoints) {
			lon[i] = v.getLongitude();
			i++;
		}
		return lon;
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		double difflat = (latitude2 - latitude1);
		double difflon = (longitude2 - longitude1);
		
		double a = Math.pow(Math.sin(difflat/2), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(difflon)/2, 2);
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		d = R*c;
		return d;
		
		

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		
		int sec1 = gpspoint1.getTime();
		int sec2 = gpspoint2.getTime();
		secs = sec2 - sec1;
		
		double d = distance(gpspoint1, gpspoint2);
		
		speed = (d/secs)*3.6;
		
		return speed;
		
		

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		// TODO - START
		int hh, mm, ss;
		
		hh = secs/3600;
		mm = (secs%3600)/60;
		ss = (secs%3600)%60;
		
		timestr = "  " + String.format("%02d", hh) + TIMESEP + String.format("%02d", mm) + TIMESEP + String.format("%02d", ss);
		
		return timestr;
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str="";

		// TODO - START

		d = (Math.round(d*100)/100.0);
		str = str + d;
		str = String.format("%10s", str);
		return str;
		// TODO - SLUTT
		
	}
}
