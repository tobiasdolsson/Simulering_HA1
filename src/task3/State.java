package task3;

import java.util.*;
import java.io.*;

class State {
	public int numberInQueue1 = 0, numberInQueue2 = 0, accumulated1 = 0, accumulated2 = 0, noMeasurements = 0;
	public int noArrivals1 = 0, noArrivals2 = 0;
	public double totalTime;
	public double arrivalTime;

	Random slump = new Random();

	public void TreatEvent(Event x) {
		switch (x.eventType) {
		case G.ARRIVAL_TO_1: {

			noArrivals1++;
			totalTime = totalTime + (numberInQueue1 * expDist(G.serviceTime1));
			EventList.InsertEvent(G.ARRIVAL_TO_1, G.time + expDist(arrivalTime));
			numberInQueue1++;

			if (numberInQueue1 == 1) {
				double serviceTime = expDist(G.serviceTime1);
				totalTime = totalTime + serviceTime;
				EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time + serviceTime);
			}

		}
			break;
		case G.DEPARTURE_FROM_1: {
			numberInQueue1--;
			totalTime = totalTime + (numberInQueue2 * expDist(G.serviceTime2));
			numberInQueue2++;

			noArrivals2++;
			if (numberInQueue2 == 1) {
				double serviceTime = expDist(G.serviceTime2);
				totalTime = totalTime + serviceTime;
				EventList.InsertEvent(G.DEPARTURE_FROM_2, G.time + serviceTime);
			}
			if (numberInQueue1 > 0) {
				double serviceTime = expDist(G.serviceTime1);
				totalTime = totalTime + serviceTime;
				EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time + serviceTime);

			}

		}
			break;

		case G.DEPARTURE_FROM_2: {
			numberInQueue2--;
			if (numberInQueue2 > 0) {
				double serviceTime = expDist(G.serviceTime2);
				totalTime = totalTime + serviceTime;
				EventList.InsertEvent(G.DEPARTURE_FROM_2, G.time + serviceTime);

			}
		}
			break;

		case G.MEASURE: {
			accumulated1 = accumulated1 + numberInQueue1;
			accumulated2 = accumulated2 + numberInQueue2;
			noMeasurements++;
			EventList.InsertEvent(G.MEASURE, G.time + expDist(G.measureTime));
		}
			break;

		}
	}

	private double expDist(double mean) {
		return -(mean) * Math.log(slump.nextDouble());
	}

}