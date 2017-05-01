package task6;

import java.util.*;
import java.io.*;

//testing commit

public class Template2006 {

	public static void main(String[] args) throws IOException {
		double totalTime = 0.0;
		
		for(int i=0; i<100; i++){
			Event actEvent;
			State actState = new State();
			new EventList();
			EventList.InsertEvent(G.ARRIVAL_TO_1, 0);
			
			EventList.InsertEvent(G.MEASURE, 4);
			
			while (actState.closed == false || actState.numberInQueue>0) {
				actEvent = EventList.FetchEvent();
				G.time = actEvent.eventTime;
				actState.TreatEvent(actEvent);
			}
			totalTime = totalTime + G.time;
			System.out.println(G.time);
		}
		
	System.out.println(totalTime/100.0);
		
	}
}