package task1;

import java.util.*;
import java.io.*;

//testing commit

public class Template2006 {
 
    public static void main(String[] args) throws IOException {
    	Event actEvent;
    	State actState = new State();
    	new EventList();
        EventList.InsertEvent(G.ARRIVAL_TO_1, 0);
        EventList.InsertEvent(G.MEASURE_1, 5);
        //EventList.InsertEvent(G.MEASURE2, 5);
    	while (actState.noMeasurements1 < 1000){
    		actEvent = EventList.FetchEvent();
    		G.time = actEvent.eventTime;
    		actState.TreatEvent(actEvent);
    	}
    	System.out.println(1.0*actState.accumulated1/actState.noMeasurements1);
    	System.out.println("Accumulated: "+actState.accumulated1);
    	//System.out.println("Accumulated Rejected: "+actState.accRejected);
    	System.out.println("Measurements: "+actState.noMeasurements1);
    	System.out.println("Arrivals: "+ actState.noArrivals1);
    	System.out.println("Rejected: "+actState.rejected);
    	System.out.println("Rejected ratio: "+1.0*actState.rejected/actState.noArrivals1);
    	//System.out.println("Rejected ratio: "+actState.accRejected/actState.accumulated1);
    	System.out.println("Time: "+G.time);
    	actState.W.close();
    }
}