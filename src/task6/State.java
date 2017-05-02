package task6;

import java.util.*;
import java.io.*;

class State {
	public int numberInQueue = 0, accumulated1 = 0, noMeasurements = 0;
	public int noArrivals = 0;
	public int openingTime = 60 * 8;
	public boolean closed = false;
	public double customerTime = 0.0;

	Random slump = new Random();

	public void TreatEvent(Event x) {
		switch (x.eventType) {

		case G.ARRIVAL_TO_1: {
			noArrivals++;

			if (G.time < openingTime) {;
				double serviceTime = 10 + 10 * slump.nextDouble();
				numberInQueue++;
				customerTime = customerTime + (serviceTime * numberInQueue);
				EventList.InsertEvent(G.ARRIVAL_TO_1, G.time + expDist(15));

			} else {
				//System.out.println("closed, remaining customers: "+numberInQueue);
			}

			if (numberInQueue == 1) {
				
				double serviceTime = (10 + 10 * slump.nextDouble());
				EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time + serviceTime);
				
			}

			if (G.time > openingTime) {
				closed = true;
			}

		}

			break;

		case G.DEPARTURE_FROM_1: {
			
			numberInQueue--;
			if (numberInQueue > 0) {
				double serviceTime = (10 + 10 * slump.nextDouble());
				EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time + serviceTime);

			}

		}
			break;

		case G.MEASURE: {

			noMeasurements++;
			EventList.InsertEvent(G.MEASURE, G.time + 100);

		}
			break;

		}
	}

	private double expDist(double mean) {
		return -(mean) * Math.log(slump.nextDouble());
	}

}