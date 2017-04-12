package task2;

import java.util.*;
import java.io.*;

class State {
	public int numberInQueue = 0, accumulated = 0, noMeasurements = 0;
	public int noArrivals = 0;
	public int rejected;
	public int accRejected;
	int test;
	
	Random slump = new Random();
	SimpleFileWriter W = new SimpleFileWriter("number.m", false);

	public void TreatEvent(Event x) {
		
		switch (x.eventType) {
		
		case G.JOB_OF_TYPE_A: {

			noArrivals++;
			EventList.InsertEvent(G.JOB_OF_TYPE_A, G.time - (1.0*1/150)*Math.log(slump.nextDouble()));
			
				numberInQueue++;
				//System.out.println(G.time);
		//System.out.println("A");
				//System.out.println(numberInQueue);
			if (numberInQueue == 1) {
				EventList.InsertEvent(G.DEPARTURE_FROM_A, G.time + 0.002);
				
				
			}

		}
			break;
			
		case G.JOB_OF_TYPE_B: {
			numberInQueue++;
			System.out.println("B");		
			if (numberInQueue > 0) {
				EventList.InsertEvent(G.DEPARTURE_FROM_B, G.time + 0.004);
			}

		}
			break;				
			
	
		case G.DEPARTURE_FROM_A: {
			numberInQueue--;
			System.out.println("DA");
			EventList.InsertEvent(G.JOB_OF_TYPE_B, G.time + 1);
			
			
			if (numberInQueue > 0){
				EventList.InsertEvent(G.DEPARTURE_FROM_A, G.time + 0.002);
			}

		}
			break;
			
			
		case G.DEPARTURE_FROM_B: {
			System.out.println("DB");
			numberInQueue--;

		}
			break;
			
			

		case G.MEASURE: {
			accumulated = accumulated + numberInQueue;
			noMeasurements++;
			EventList.InsertEvent(G.MEASURE, G.time + 0.1);
		}
			break;

		}
	}
}