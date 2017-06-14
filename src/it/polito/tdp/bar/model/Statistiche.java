package it.polito.tdp.bar.model;

public class Statistiche {

	private int totaleGruppi = 0;
	private int gruppiSoddisfatti = 0;
	private int gruppiInsoddisfatti = 0;
	
	private int totaleClienti = 0;
	private int clientiSoddisfatti = 0;
	private int clientiInsoddisfatti = 0;

	private int tavoli = 0;
	
	public void setNumTavoli(int tavoli) {
		this.tavoli = tavoli;
	}

	public void clean() {
		this.totaleGruppi = 0;
		this.gruppiSoddisfatti = 0;
		this.gruppiInsoddisfatti = 0;
		
		this.totaleClienti = 0; 
		this.clientiSoddisfatti = 0;
		this.clientiInsoddisfatti = 0;
	}

	public void aggiungiClienti(GruppoClienti clienti) {

		totaleGruppi++;
		totaleClienti += clienti.getNumeroPersone();
		
		if (clienti.isSoddisfatti()) {
			gruppiSoddisfatti++;
			clientiSoddisfatti += clienti.getNumeroPersone();
		} else {
			gruppiInsoddisfatti++;
			clientiInsoddisfatti += clienti.getNumeroPersone();
		}
	}

	@Override
	public String toString() {

		String risultato="";
		
		risultato += "Totale Gruppi:  "+this.totaleGruppi+"\n";
		risultato += "Gruppi Soddisfatti:  "+this.gruppiSoddisfatti+"\n";
		risultato += "Gruppi Insoddisfatti:  "+this.gruppiInsoddisfatti+"\n";
		risultato += "Totale Clienti:  "+this.totaleClienti+"\n";
		risultato += "Clienti Soddisfatti:  "+this.clientiSoddisfatti+"\n";
		risultato += "Clienti Insoddisfatti:  "+this.clientiInsoddisfatti+"\n";
		risultato += "Numero tavoli con cui lavora il simulatore:  "+this.tavoli+"\n\n\n";

		return risultato;
	}
	
}
