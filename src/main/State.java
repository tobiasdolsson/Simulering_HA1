package main;

import java.util.*;
import java.io.*;

class State{
	public int numberInQueue = 0, accumulated = 0, noMeasurements = 0;
	public int rejected;

	Random slump = new Random();
	SimpleFileWriter W = new SimpleFileWriter("number.m", false);
	
	public void TreatEvent(Event x){
		switch (x.eventType){
			case G.ARRIVAL_TO_1:{
				numberInQueue++;
				System.out.println(numberInQueue);
				EventList.InsertEvent(G.ARRIVAL_TO_1, G.time - (1/0.9)*Math.log(slump.nextDouble()));
				if (numberInQueue == 1){
					EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time + 1);
				}
			} break;
			case G.DEPARTURE_FROM_1:{
				numberInQueue--;
				if (numberInQueue > 0){
					EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time + 1);
				}
			} break;
			
			case G.DEPARTURE_FROM_2:{
				
			}
			
			case G.MEASURE:{
				accumulated = accumulated + numberInQueue;
				noMeasurements++;
				EventList.InsertEvent(G.MEASURE, G.time + 5);
				W.println(String.valueOf(numberInQueue));
			} break;
		}
	}
}