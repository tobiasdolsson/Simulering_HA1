package task3;

import java.util.*;
import java.io.*;

//testing commit

public class Template2006 {

	public static void main(String[] args) throws IOException {
		Event actEvent;
		State actState1 = new State();
		State actState2 = new State();
		State actState3 = new State();
		new EventList();
		
		actState1.arrivalTime = 2.0;
		EventList.InsertEvent(G.ARRIVAL_TO_1, 0);
		EventList.InsertEvent(G.MEASURE, 5);
		while (actState1.noMeasurements < 10000) {
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
		
		actState2.arrivalTime = 1.5;
		EventList.InsertEvent(G.ARRIVAL_TO_1, 0);
		EventList.InsertEvent(G.MEASURE, 5);
		while (actState2.noMeasurements < 10000) {
			actEvent = EventList.FetchEvent();
			G.time = actEvent.eventTime;
			actState2.TreatEvent(actEvent);
		}
		
		System.out.println("\nMean arrival time = " + actState2.arrivalTime);
		System.out.println("Mean in Q1: " + 1.0 * actState2.accumulated1 / actState2.noMeasurements);
		System.out.println("Mean in Q2: " + 1.0 * actState2.accumulated2 / actState2.noMeasurements);
		System.out.println("Mean number of customers in queuing network: " + ((1.0 * actState2.accumulated2 / actState2.noMeasurements) + (1.0 * actState2.accumulated1 / actState2.noMeasurements)));
		System.out.println("Mean number of customers with formula: " + 2.0/(actState2.arrivalTime-1.0));
		System.out.println("Mean time in queuing network: "+ actState2.totalTime/actState2.noArrivals1);
		System.out.println("Mean time in queuing network with formula: " + (2.0*actState2.arrivalTime)/(actState2.arrivalTime-1.0));
		
		
		actState3.arrivalTime = 1.1;
		EventList.InsertEvent(G.ARRIVAL_TO_1, 0);
		EventList.InsertEvent(G.MEASURE, 5);
		while (actState3.noMeasurements < 10000) {
			actEvent = EventList.FetchEvent();
			G.time = actEvent.eventTime;
			actState3.TreatEvent(actEvent);
		}
		
		System.out.println("\nMean arrival time = " + actState3.arrivalTime);
		System.out.println("Mean in Q1: " + 1.0 * actState3.accumulated1 / actState3.noMeasurements);
		System.out.println("Mean in Q2: " + 1.0 * actState3.accumulated2 / actState3.noMeasurements);
		System.out.println("Mean number of customers in queuing network: " + ((1.0 * actState3.accumulated2 / actState3.noMeasurements) + (1.0 * actState3.accumulated1 / actState3.noMeasurements)));
		System.out.println("Mean number of customers with formula: " + 2.0/(actState3.arrivalTime-1.0));
		System.out.println("Mean time in queuing network: "+ actState3.totalTime/actState3.noArrivals1);
		System.out.println("Mean time in queuing network with formula: " + (2.0*actState3.arrivalTime)/(actState3.arrivalTime-1.0));
		
		
	}
}