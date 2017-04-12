package task2;

import java.util.*;
import java.io.*;

class State {
	public int numberInQueue = 0, accumulated = 0, noMeasurements = 0;
	public int noArrivals = 0;
	public int rejected;
	public int accRejected;

	Random slump = new Random();
	SimpleFileWriter W = new SimpleFileWriter("number.m", false);

	public void TreatEvent(Event x) {
		switch (x.eventType) {
		case G.JOB_OF_TYPE_A: {

			noArrivals++;
			EventList.InsertEvent(G.JOB_OF_TYPE_A, G.time + (1.0*1/150)*Math.log(slump.nextDouble()));
			
				numberInQueue++;
		
			if (numberInQueue == 1) {
				EventList.InsertEvent(G.DEPARTURE_FROM_A, G.time + 0.002);
			}

		}
			break;
			
		case G.JOB_OF_TYPE_B: {
			numberInQueue++;
						
			if (numberInQueue > 0) {
				EventList.InsertEvent(G.DEPARTURE_FROM_B, G.time + 0.004);
			}

		}
			break;				
			
	
		case G.DEPARTURE_FROM_A: {
			numberInQueue--;
						
			if (numberInQueue > 0) {
				EventList.InsertEvent(G.JOB_OF_TYPE_B, G.time + 1);
			}

		}
			break;
			
			
		case G.DEPARTURE_FROM_B: {
			numberInQueue--;

		}
			break;
			
			

		case G.MEASURE: {
			accumulated = accumulated + numberInQueue;
			noMeasurements++;
			EventList.InsertEvent(G.MEASURE, G.time - (5.0) * Math.log(slump.nextDouble()));
		}
			break;

		}
	}
}