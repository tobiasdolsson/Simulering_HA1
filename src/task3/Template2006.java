package task3;

import java.util.*;
import java.io.*;

public class Template2006 {

	public static void main(String[] args) throws IOException {
		Event actEvent;
		State actState1 = new State();

		new EventList();
		
		actState1.arrivalTime = 1.1;
		EventList.InsertEvent(G.ARRIVAL_TO_1, 0);
		EventList.InsertEvent(G.MEASURE, 5);
		while (actState1.noMeasurements < 1000000) {
			actEvent = EventList.FetchEvent();
			G.time = actEvent.eventTime;
			actState1.TreatEvent(actEvent);
		}
		
		System.out.println("Mean arrival time = " + actState1.arrivalTime);
		System.out.println("Mean in Q1: " + 1.0 * actState1.accumulated1 / actState1.noMeasurements);
		System.out.println("Mean in Q2: " + 1.0 * actState1.accumulated2 / actState1.noMeasurements);
		System.out.println("Mean number of customers in queuing network: " + ((1.0 * actState1.accumulated2 / actState1.noMeasurements) + (1.0 * actState1.accumulated1 / actState1.noMeasurements)));
		System.out.println("Mean number of customers with formula: " + 2.0/(actState1.arrivalTime-1.0));
		System.out.println("Mean time in queuing network: "+ actState1.totalTime/actState1.noArrivals1);
		System.out.println("Mean time in queuing network with formula: " + (2.0*actState1.arrivalTime)/(actState1.arrivalTime-1.0));
		
	}
}