package task1;

import java.util.*;
import java.io.*;

class State{
	public int numberInQueue1 = 0, numberInQueue2 = 0, accumulated1 = 0, accumulated2 = 0, noMeasurements1 = 0, noMeasurements2 = 0;
	public int noArrivals1 = 0, noArrivals2 = 0;
	public int rejected;
	public int accRejected;

	Random slump = new Random();
	SimpleFileWriter W = new SimpleFileWriter("number.m", false);
	
	public void TreatEvent(Event x){
		switch (x.eventType){
			case G.ARRIVAL_TO_1:{
				
				noArrivals1++;
				//System.out.println(noArrivals1);
				EventList.InsertEvent(G.ARRIVAL_TO_1, G.time + 1);
				System.out.println(G.time);
				if (numberInQueue1 < 10){
					numberInQueue1++;
				} else {
					rejected++;
				}
				
				if (numberInQueue1 == 1){
					EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time - (2.1)*Math.log(slump.nextDouble()));
				}

			} break;
			case G.DEPARTURE_FROM_1:{
				numberInQueue1--;
				numberInQueue2++;
				noArrivals2++;
				if (numberInQueue2 == 1){
					EventList.InsertEvent(G.DEPARTURE_FROM_2, G.time + 2);
				}
				if (numberInQueue1 > 0){
					EventList.InsertEvent(G.DEPARTURE_FROM_1, G.time - (2.1)*Math.log(slump.nextDouble()));
				}
				
			} break;
			
			case G.DEPARTURE_FROM_2:{
				numberInQueue2--;
				if (numberInQueue2 > 0){
					EventList.InsertEvent(G.DEPARTURE_FROM_2, G.time + 2);
				}
			} break;
			
			case G.MEASURE_1:{
				accumulated1 = accumulated1 + numberInQueue1;
				//accRejected = accRejected + rejected;
				noMeasurements1++;
				System.out.println("köres detta? "+noMeasurements1);
				//System.out.println(G.time);
				EventList.InsertEvent(G.MEASURE_1, G.time - (5.0)*Math.log(slump.nextDouble()));
				//W.println(String.valueOf(numberInQueue1));
			} break;
			
			case G.MEASURE2:{
				accumulated2 = accumulated2 + numberInQueue2;
				noMeasurements2++;
				EventList.InsertEvent(G.MEASURE2, G.time - (5.0)*Math.log(slump.nextDouble()));
				//W.println(String.valueOf(numberInQueue2));
			} break;
			
		}
	}
}