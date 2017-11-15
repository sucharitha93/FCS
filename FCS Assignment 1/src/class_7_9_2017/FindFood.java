package class_7_9_2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindFood {
	static double dist(double x1, double y1, double x2, double y2) {
		return Math.toDegrees(1.1516 * 60 * Math.acos(Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2))
				+ Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1 - y2))));
	}

	int findNext(double x, double y, double[] lat, double[] lon) {
		double d = 0, t;
		int i = 0, index = 0;
		for (i = 0; i < lat.length; i++) {
			t = dist(x, y, lat[i], lon[i]);
			if (t > d) {
				d = t;
				index = i;
			}
		}
		return index;
	}

	void markFound(int f, double[] lat, double[] lon) {
		lat[f - 1] = Double.POSITIVE_INFINITY;
		lon[f - 1] = Double.POSITIVE_INFINITY;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Number of restaurants: ");
		int n = in.nextInt();
		double curLat, curLon;
		int r;
		ArrayList<Restaurant> restList = new ArrayList<Restaurant>();
		for (int i = 0; i < n; i++) {
			restList.add(new Restaurant(in.next(),in.nextDouble(),in.nextDouble(),in.nextInt()));
		}
		System.out.println("Current location: ");
		curLat = in.nextDouble();
		curLon = in.nextDouble();
		System.out.println("Minimum rating: ");
		r = in.nextInt();

		for (int i = 0; i < n; i++) {
			restList.get(i).setDistance(dist(curLat,curLon,restList.get(i).getLat(),restList.get(i).getLon()));
		}
		
		 Collections.sort(restList, new Restaurant());
	      
		  for(Restaurant a: restList)
		  {	    	  
			  if(a.getRating()>=r)
			  {
				  System.out.println(a.getName() +" has a rating of "+ a.getRating());
				  System.out.println("Distance: "+a.getDistance()+" miles");
			  }	    	  
		  }
	}

}
