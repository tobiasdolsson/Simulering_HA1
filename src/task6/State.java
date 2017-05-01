package task6;

import java.util.*;
import java.io.*;

class State {
	public int numberInQueue = 0, numberInQueue2 = 0, accumulated1 = 0, accumulated2 = 0, noMeasurements = 0;
	public int noArrivals1 = 0, noArrivals2 = 0;
	public int rejected;
	public int accRejected;
	public int openingTime = 60 * 8;
	public boolean closed = false;

	Random slump = new Random();
	SimpleFileWriter W = new SimpleFileWriter("number.m", false);

	public LinkedList<Double> queue;

	public void TreatEvent(Event x) {
		switch (x.eventType) {

		case G.ARRIVAL_TO_1: {
			noArrivals1++;

			if (G.time < openingTime) {
				numberInQueue++;
				EventList.InsertEvent(G.ARRIVAL_TO_1, G.time + expDist(15));

			} else {
				System.out.println("stängt");
			}

			if (numberInQueue == 1) {
				EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time + (10 + 10 * slump.nextDouble()));
			}

			if (G.time>openingTime){
				closed = true;
			}

		}

			break;

		case G.DEPARTURE_FROM_1: {
			
			numberInQueue--;
			if(numberInQueue>0){
				EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time + (10 + 10 * slump.nextDouble()));
				
			}

		}
			break;

		case G.MEASURE: {

			noMeasurements++;
			EventList.InsertEvent(G.MEASURE, G.time + 4);
			//System.out.println(numberInQueue);

		}
			break;

		}
	}

	private double expDist(double mean) {
		return -(mean) * Math.log(slump.nextDouble());
	}

}