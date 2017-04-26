package task3;

import java.util.*;
import java.io.*;

//testing commit

public class Template2006 {

	public static void main(String[] args) throws IOException {
		Event actEvent;
		State actState = new State();
		new EventList();
		EventList.InsertEvent(G.ARRIVAL_TO_1, 0);
		EventList.InsertEvent(G.MEASURE, 5);
		while (actState.noMeasurements < 100000) {
			actEvent = EventList.FetchEvent();
			G.time = actEvent.eventTime;
			actState.TreatEvent(actEvent);
		}

		System.out.println("Accumulated: " + actState.accumulated1);
		System.out.println("Measurements: " + actState.noMeasurements);
		System.out.println("Time: " + G.time);
		System.out.println("Arrivals: " + actState.noArrivals1);
		
		System.out.println("Mean in Q1: " + 1.0 * actState.accumulated1 / actState.noMeasurements);
		System.out.println("Mean in Q2: " + 1.0 * actState.accumulated2 / actState.noMeasurements);
		//double Q1 = 1.0 * actState.accumulated1 / actState.noMeasurements;
		//double Q2 = 1.0 * actState.accumulated2 / actState.noMeasurements;
		System.out.println("Mean number of customers in queuing network: " + ((1.0 * actState.accumulated2 / actState.noMeasurements) + (1.0 * actState.accumulated1 / actState.noMeasurements)));
		//System.out.println(Q1+Q2);
		System.out.println("N: " + 2.0/(G.arrivalTime-1.0));
		
		System.out.println("Mean time in queuing network: "+ G.time/actState.noArrivals1);
		System.out.println("T: " + (2.0*G.arrivalTime)/(G.arrivalTime-1.0));
		

		actState.W.close();
	}
}