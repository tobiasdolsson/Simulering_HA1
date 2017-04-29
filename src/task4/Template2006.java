package task4;

import java.util.*;
import java.io.*;

//testing commit

public class Template2006 {

	public static void main(String[] args) throws IOException {
		Event actEvent;
		State actState = new State();
		new EventList();
		EventList.InsertEvent(G.ARRIVAL_TO_1, 0);
		
		EventList.InsertEvent(G.MEASURE, 4);
		
		while (actState.noMeasurements < 1000) {
			actEvent = EventList.FetchEvent();
			G.time = actEvent.eventTime;
			actState.TreatEvent(actEvent);
		}

		actState.W.close();
	}
}