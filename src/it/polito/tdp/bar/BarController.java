package it.polito.tdp.bar;

import java.util.Random;

import it.polito.tdp.bar.model.Event;
import it.polito.tdp.bar.model.GruppoClienti;
import it.polito.tdp.bar.model.Simulator;
import it.polito.tdp.bar.model.Event.EventType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BarController {

	private Simulator simulator;
	
    @FXML
    private TextArea txtRisultato;
    
    public void setSimulator(Simulator simulator) {
    	this.simulator = simulator;
    	
    	simulator.addTavolo(10);
    	simulator.addTavolo(10);

    	simulator.addTavolo(8);
    	simulator.addTavolo(8);
    	simulator.addTavolo(8);
    	simulator.addTavolo(8);

    	simulator.addTavolo(6);
    	simulator.addTavolo(6);
    	simulator.addTavolo(6);
    	simulator.addTavolo(6);

    	simulator.addTavolo(4);
    	simulator.addTavolo(4);
    	simulator.addTavolo(4);
    	simulator.addTavolo(4);
    	simulator.addTavolo(4);
    }
    
    @FXML
    void doSimula(ActionEvent event) {
    	
    	simulator.clean();
    	
		Random random = new Random(42);

		int ultimoTempoDiArrivo = 0;
		
		for (int t = 0; t < 2000; ++t) {
			
			int tempoDiArrivo = ultimoTempoDiArrivo + 1 + random.nextInt(9);
			int durata = (int) (60 + Math.random() * 60);
			float tolleranza = random.nextFloat();
			int numeroPersone =  1 + random.nextInt(9);
			
			GruppoClienti gruppoClienti = new GruppoClienti(tempoDiArrivo, durata, tolleranza, numeroPersone);
			
			Event e = new Event(gruppoClienti, tempoDiArrivo, EventType.ARRIVO_GRUPPO_CLIENTI);
			simulator.addEvent(e);
		}
		
		simulator.run();
		
		txtRisultato.appendText(simulator.getStatistiche().toString());	
    }
    
    @FXML
    void initialize() {
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Bar.fxml'.";
    }
	
}
