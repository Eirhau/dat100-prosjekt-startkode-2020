package no.hvl.dat100ptc.oppgave5;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import javax.swing.JOptionPane;

public class ShowProfile extends EasyGraphics {

	private static final int MARGIN = 50;		// margin on the sides 
	
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

		makeWindow("Height profile", 2 * MARGIN + 4 * N, 2 * MARGIN + MAXBARHEIGHT);

		// top margin + height of drawing area
		showHeightProfile(MARGIN + MAXBARHEIGHT); 
	}
	 
	public void showHeightProfile(int ybase) {

		// ybase indicates the position on the y-axis where the columns should start

		
		
		
		int x = MARGIN, y;
		
		GPSComputer test = new GPSComputer(gpspoints);
		double[] speeds = test.speeds();
		int scalar = Integer.parseInt(getText("Skalar: "));
		// TODO - START
		int diff = 4;
		int timediff;
		int y1;
		int y2;
		int r = 4;
		int circle = fillCircle(0,0,0);	
		
		double minSpeed = GPSUtils.findMax(speeds);
		double maxSpeed = GPSUtils.findMin(speeds);
		double diffSpeed = maxSpeed - minSpeed;
		// 17 37
	
		for (int i = 0; i < speeds.length ; i++) {
			System.out.println((int)Math.round(9*(speeds[i]-minSpeed)/diffSpeed)+1);
		}
		
		for (int i = 1 ; i < gpspoints.length ; i++) {
			y1 = ybase-(int)gpspoints[i-1].getElevation();
			y2 = ybase-(int)gpspoints[i].getElevation();
			
			setSpeed((int)Math.round(9*(speeds[i-1]-minSpeed)/diffSpeed)+1);
			
			move(circle, x,y1);
			drawLine(x, ybase, x, ybase-(int)gpspoints[i-1].getElevation());
			drawLine(x, y1, x+diff, y2);
			
			if (i==1) {
				circle = fillCircle(x,y1, r);
			}
			
			timediff = gpspoints[i].getTime() - gpspoints[i-1].getTime();
			pause(timediff*1000/scalar);
			
			x+=diff;
		}
	
		// TODO - SLUTT
	}

}
