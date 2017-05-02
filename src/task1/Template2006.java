package task1;

import java.util.*;
import java.io.*;

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

		System.out.println("Arrivals: " + actState.noArrivals1);
		System.out.println("Rejected: " + actState.rejected);
		System.out.println("Rejected ratio: " + 1.0 * actState.rejected / actState.noArrivals1);
		System.out.println("Mean in Q1: " + 1.0 * actState.accumulated1 / actState.noMeasurements);
		System.out.println("Mean in Q2: " + 1.0 * actState.accumulated2 / actState.noMeasurements);

	}
}