package main;

import java.util.*;
import java.io.*;

//testing commit

public class Template2006 {
 
    public static void main(String[] args) throws IOException {
    	Event actEvent;
    	State actState = new State();
    	new EventList();
        EventList.InsertEvent(G.ARRIVAL_TO_1, 1);
        EventList.InsertEvent(G.MEASURE1, 5);
        //EventList.InsertEvent(G.MEASURE2, 5);
    	while (actState.noMeasurements1 < 1000){
    		actEvent = EventList.FetchEvent();
    		G.time = actEvent.eventTime;
    		actState.TreatEvent(actEvent);
    	}
    	System.out.println(1.0*actState.accumulated1/actState.noMeasurements1);
    	System.out.println("Accumulated: "+actState.accumulated1);
    	System.out.println("Measurements: "+actState.noMeasurements1);
    	System.out.println("Rejected: "+actState.rejected);
    	System.out.println("Rejected ratio: "+actState.rejected/actState.noArrivals1);
    	actState.W.close();
    }
}