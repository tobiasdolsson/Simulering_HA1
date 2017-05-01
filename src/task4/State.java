package task4;

import java.util.*;
import java.io.*;

class State {
	public int numberInQueue1 = 0, numberInQueue2 = 0, accumulated1 = 0, accumulated2 = 0, noMeasurements = 0;
	public int noArrivals1 = 0, noArrivals2 = 0;
	public int rejected;
	public int accRejected;
	public int numberOfServers = 100;
	public int busyServers = 0;
	public double lambda = 1.0 / 4.0;

	Random slump = new Random();
	SimpleFileWriter W = new SimpleFileWriter("number.m", false);

	public void TreatEvent(Event x) {
		switch (x.eventType) {

		case G.ARRIVAL_TO_1: {
			noArrivals1++;
			EventList.InsertEvent(G.ARRIVAL_TO_1, G.time + expDist(lambda));

			if (busyServers < numberOfServers) {
				busyServers++;
				EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time + 10);
			} else {
				System.out.println("Rejected");
			}

		}

			break;

		case G.DEPARTURE_FROM_1: {

			busyServers--;

		}
			break;

		case G.MEASURE: {

			noMeasurements++;
			EventList.InsertEvent(G.MEASURE, G.time + 4);
			String customers = Integer.toString(busyServers);

			W.println(customers);

		}
			break;

		}
	}

	private double expDist(double mean) {
		return -(mean) * Math.log(slump.nextDouble());
	}

}