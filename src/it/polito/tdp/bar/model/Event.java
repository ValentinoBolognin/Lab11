package it.polito.tdp.bar.model;

public class Event implements Comparable<Event> {
	
	public enum EventType {
		ARRIVO_GRUPPO_CLIENTI, 
		PARTENZA_GRUPPO_CLIENTI
		};

	private GruppoClienti gruppoCienti;
	private int time;
	private EventType type; 
	
	public Event(GruppoClienti gruppoCienti, int time, EventType type) {
		super();
		this.gruppoCienti = gruppoCienti;
		this.time = time;
		this.type = type;
	}

	public GruppoClienti getGruppoClienti() {
		return gruppoCienti;
	}

	public void setGruppoClienti(GruppoClienti gruppoClienti) {
		this.gruppoCienti = gruppoClienti;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public int compareTo(Event other) {
		return this.time - other.time;
	}
}
