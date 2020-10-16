package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;
import no.hvl.dat100ptc.oppgave6.CycleComputer;


public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 1500;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;

	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 4 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon));

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {

		double ystep;

		// TODO - START

		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		ystep = MAPYSIZE / (Math.abs(maxlat - minlat));

		return ystep;

		// TODO - SLUTT

	}
	
	public void showRouteMap(int ybase) {

		// TODO - START
		// minste lat skal ha y = ybase 
		// minste lon skal ha x
		

		double lon[] = GPSUtils.getLongitudes(gpspoints);
		double lat[] = GPSUtils.getLatitudes(gpspoints);
		
		int x;
		int y = ybase;
		
		setColor(255,0,0);
		
		
		for (int i = 1; i < gpspoints.length; i++) {
			i--;
			x = (int)(((lon[i] - GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints)))*xstep()));
			y = (int)(((lat[i] - GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints)))*ystep()));
			
			
			if (CycleComputer.climbs(gpspoints)[i] > 0){
				setColor(255,0,0);
			} else if (CycleComputer.climbs(gpspoints)[i] == 0) {
				setColor(0,0,255);
			} else {
				setColor(0,255,0);
			}
			i++;
			fillCircle(x+MARGIN, (ybase - y), 5);
			
		}

		
		
		
		// TODO - SLUTT
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0, 0, 0);
		setFont("Courier", 12);
		

		// TODO - START
		double WEIGHT = 80.0;
		
		String TimeTxt 		= String.format("%-20s","Total time") + ":"+ GPSUtils.formatTime(gpscomputer.totalTime());
		String DistanceTxt	= (String.format("%-20s","Total distance") + ":" + String.format("%10.2f",gpscomputer.totalDistance()/1000.0) + " km");
		String ElevationTxt	= (String.format("%-20s","Total elevation") + ":"+ String.format("%10.2f", gpscomputer.totalElevation()) + " m");
		String MSpeedTxt	= (String.format("%-20s","Max speed") + ":"+ String.format("%10.2f", gpscomputer.maxSpeed()) + " km/t");
		String ASpeedTxt	= (String.format("%-20s","Average speed") + ":" + String.format("%10.2f" , gpscomputer.averageSpeed()) + " km/t");
		String EnergyTxt	= (String.format("%-20s","Energy") + ":" + String.format("%10.2f", gpscomputer.totalKcal(WEIGHT)) + " kcal");
		
		String[] str = new String[6];
		str [0] = TimeTxt;
		str[1] = DistanceTxt;
		str[2] = ElevationTxt;
		str[3] = MSpeedTxt;
		str[4] = ASpeedTxt;
		str[5] = EnergyTxt;
		
		for (int i = 0; i < str.length ; i++) {
			drawString(str[i], MARGIN, MARGIN+TEXTDISTANCE*i);
		}
		// TODO - SLUTT;
	}

}
