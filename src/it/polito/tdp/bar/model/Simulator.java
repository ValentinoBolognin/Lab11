package it.polito.tdp.bar.model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import it.polito.tdp.bar.model.Event.EventType;

public class Simulator {

	private Random random;
	private Statistiche statistiche;
	private Queue<Event> queue;
	private Map<Integer, Tavolo> tavoli;

	public Simulator() {
		random = new Random(42);
		statistiche = new Statistiche();
		queue = new PriorityQueue<Event>();
		tavoli = new HashMap<Integer, Tavolo>();
	}

	public void addEvent(Event e) {
		queue.add(e);
	}
	
	public void addTavolo(int numeroPosti) {
		Tavolo temp = new Tavolo(numeroPosti);
		tavoli.put(temp.getIdTavolo(), temp);
		statistiche.setNumTavoli(tavoli.size());
	}
	
	public void clean() {
		queue.clear();
		statistiche.clean();
	}
	
	public Statistiche getStatistiche() {
		return this.statistiche;
	}

	public void run() {
		while (!queue.isEmpty()) {
			
			Event e = queue.poll();

			switch (e.getType()) {
			
			case ARRIVO_GRUPPO_CLIENTI:
	
				Tavolo tavolo = trovaTavoloLibero(e.getGruppoClienti().getNumeroPersone());
	
				if (tavolo != null) {
	
					tavolo.setLibero(false);
					e.getGruppoClienti().setSoddisfatti(true);
	
					Event event = new Event(e.getGruppoClienti(), e.getTime()+e.getGruppoClienti().getDurata(), EventType.PARTENZA_GRUPPO_CLIENTI);
					addEvent(event);
	
				} else {
	
					float tolleranza = e.getGruppoClienti().getTolleranza();
					float probabilita = random.nextFloat();
	
					if (probabilita <= tolleranza) {
						e.getGruppoClienti().setSoddisfatti(true);
						
					} else {
						e.getGruppoClienti().setSoddisfatti(false);
					}
				}
				statistiche.aggiungiClienti(e.getGruppoClienti());
				
				break;
	
			case PARTENZA_GRUPPO_CLIENTI:
	
				Tavolo tavoloLibero = this.trovaTavolo(e.getGruppoClienti().getIdGruppoClienti());
				tavoloLibero.setLibero(true);
				tavoloLibero.setIdGruppoClienti(-1);
	
				break;
	
			default:
				throw new IllegalArgumentException();
	
			}
		}	
	}

	private Tavolo trovaTavoloLibero(int numeroPersone) {
		int minPosti = Integer.MAX_VALUE;
		Tavolo tavolo = null;

		for (Tavolo temp : tavoli.values()) {
			if (temp.isLibero() && numeroPersone >= 0.5 * temp.getPostiASedere()) {
				if (minPosti > tavolo.getPostiASedere()) {
					minPosti = temp.getPostiASedere();
					tavolo = temp;
				}
			}
		}
		return tavolo;
	}
	
	public Tavolo trovaTavolo(int idGruppoClienti) {
		for (Tavolo tavolo : tavoli.values()) {
			if (tavolo.getIdGruppoClienti() == idGruppoClienti)
				return tavolo;
		}
		return null;
	}

}