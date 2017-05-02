package task6;

import java.util.*;
import java.io.*;


public class Template2006 {

	public static void main(String[] args) throws IOException {
		double totalTime = 0.0;
		double meanCustomerTime = 0.0;
		int numberOfDays = 1000;

		for (int i = 0; i < numberOfDays; i++) {
			Event actEvent;
			State actState = new State();
			new EventList();
			EventList.InsertEvent(G.ARRIVAL_TO_1, 0);

			while (actState.closed == false || actState.numberInQueue > 0) {
				actEvent = EventList.FetchEvent();
				G.time = actEvent.eventTime;
				actState.TreatEvent(actEvent);
			}
			totalTime = totalTime + G.time;
			meanCustomerTime = meanCustomerTime + (actState.customerTime / actState.noArrivals);
			
		}
		double minOfWork = totalTime / (double)numberOfDays;
		int hours = (int) minOfWork / 60;
		int minutes = (int) minOfWork % 60;
		
		System.out.print("Work finished at: ");
		System.out.printf("%d:%02d", hours + 9, minutes);
		System.out.println("\nMean prescription time: " + meanCustomerTime / (double)numberOfDays);

	}
}