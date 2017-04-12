package task2;

import java.util.*;
import java.io.*;

//testing commit

public class Template2006 {

	public static void main(String[] args) throws IOException {
		Event actEvent;
		State actState = new State();
		new EventList();
		EventList.InsertEvent(G.JOB_OF_TYPE_A, 0);
		EventList.InsertEvent(G.MEASURE, 5);
		while (actState.noMeasurements < 100000) {
			actEvent = EventList.FetchEvent();
			G.time = actEvent.eventTime;
			actState.TreatEvent(actEvent);
		}

		System.out.println("Accumulated: " + actState.accumulated);
		System.out.println("Measurements: " + actState.noMeasurements);
		System.out.println("Time: " + G.time);
		System.out.println("Arrivals: " + actState.noArrivals);
		System.out.println("Rejected: " + actState.rejected);
		System.out.println("Rejected ratio: " + 1.0 * actState.rejected / actState.noArrivals);
		System.out.println("Mean in Q1: " + 1.0 * actState.accumulated / actState.noMeasurements);

		actState.W.close();
	}
}