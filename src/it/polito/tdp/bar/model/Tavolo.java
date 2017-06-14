package it.polito.tdp.bar.model;

public class Tavolo {

	static private int totaleTavoli = 0;
	private int idTavolo;

	private int postiASedere;
	private boolean libero;

	private int idGruppoClienti;
	
	public Tavolo(int postiASedere) {
		idTavolo = ++totaleTavoli;
	
		this.postiASedere = postiASedere;
		this.libero = true;
	
		this.idGruppoClienti = -1;
		
	}

	public int getIdTavolo() {
		return idTavolo;
	}

	public void setIdTavolo(int idTavolo) {
		this.idTavolo = idTavolo;
	}

	public int getPostiASedere() {
		return postiASedere;
	}

	public void setPostiASedere(int postiASedere) {
		this.postiASedere = postiASedere;
	}

	public boolean isLibero() {
		return libero;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}

	
	public int getIdGruppoClienti() {
		return idGruppoClienti;
	}

	public void setIdGruppoClienti(int idGruppoClienti) {
		this.idGruppoClienti = idGruppoClienti;
	}

}
