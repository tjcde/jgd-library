package de.tj.jgdlib;

public class JGDEvent {
	
	public void callEvent(String id, JGDComponent comp) {
		switch (id) {
		case "CLICK":
			comp.setCurrentEvent("CLICK");
			break;

		case "HOVER_IN":
			comp.setCurrentEvent("HOVER_IN");
			break;
			
		case "HOVER_OUT":
			comp.setCurrentEvent("HOVER_OUT");
			break;
		}
		
		comp.onEvent();
	}

}