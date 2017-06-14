package it.polito.tdp.bar.model;

public class GruppoClienti {
	
	static private int totaleGruppoClienti = 0;
	private int idGruppoClienti;
	
	private int tempoDiArrivo;
	private int durata;
	private float tolleranza;
	private int numeroPersone;
	private boolean soddisfatti;

	public GruppoClienti(int tempoDiArrivo, int durata, float tolleranza, int numeroPersone) {
		this.idGruppoClienti = ++totaleGruppoClienti;
		
		this.tempoDiArrivo = tempoDiArrivo;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.numeroPersone = numeroPersone;
		this.soddisfatti = false;
	}

	public int getIdGruppoClienti() {
		return idGruppoClienti;
	}

	public void setIdGruppoClienti(int idGruppoClienti) {
		this.idGruppoClienti = idGruppoClienti;
	}

	public int getTempoDiArrivo() {
		return tempoDiArrivo;
	}

	public void setTempoDiArrivo(int tempoDiArrivo) {
		this.tempoDiArrivo = tempoDiArrivo;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}
	
	public boolean isSoddisfatti() {
		return soddisfatti;
	}

	public void setSoddisfatti(boolean soddisfatti) {
		this.soddisfatti = soddisfatti;
	}

	@Override
	public String toString() {
		return "Gruppo clienti#" +idGruppoClienti;
	}
	
}
