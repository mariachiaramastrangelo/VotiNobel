package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.dao.EsameDAO;

public class Model {
	
	//esami letti dal database
	private List<Esame> esami;
	//soluzione da restituire
	private List<Esame> best;
	private double media_best;
	
	public Model() {
		EsameDAO ed= new EsameDAO();
		esami= ed.getTuttiEsami();
	}
	/**
	 * trova la combinazione dei corsi ottimali 
	 * @param numeroCrediti
	 * @return l'elenco dei corsi ottimale oppure {@code null} se
	 * non trova alcuna combianzione di crediti adeguata
	 */
	public List<Esame> calcolaSottoinsiemeEsami(int numeroCrediti) {
		
		best= null;
		media_best= 0.0;
		Set<Esame> parziale= new HashSet<Esame>();
		this.cerca(parziale, 0, numeroCrediti);
		
		return best;
	}
	
	private void cerca(Set<Esame> parziale, int L, int m ) {
		//caso terminale?
		int crediti= sommaCrediti(parziale);
			if(crediti>m)
				return;
			if(crediti==m) {
				double media= calcolaMedia(parziale);
				if(media>media_best) {
					best= new ArrayList<Esame>(parziale);
					media_best=media;
					return;
					//esco perché se questa è buona ho già i crediti al massimo 
					//non posso avere soluzione più lunga di così
				}else {
					return;
					//non salvo niente dopo 
				}
			}
			
			//se ho crediti< m devo continuare per forza?
			//no se ho finito di vedere gli esami
			if(L==esami.size()) {
				return;
			}
				
		//caso normale?
		
		//l'esame in posizione L è da aggiungere o no
		//provo ad aggiungerlo oppure no
		cerca(parziale, L+1, m);
		
		//provo ad aggiungerlo
		parziale.add(esami.get(L));
		cerca(parziale, L+1, m);
		parziale.remove(esami.get(L));
		
	}
	
	
	
	
	private double calcolaMedia(Set<Esame> parziale) {
		double media=0;
		int crediti=0;
		for(Esame e: parziale) {
			media +=e.getVoto()*e.getCrediti();
			crediti+= e.getCrediti();
		}
		return media/crediti;
	}

	private int sommaCrediti(Set<Esame> parziale) {
		int somma=0;
		for(Esame e: parziale) {
			somma+=e.getCrediti();
		}
		return somma;
	}

	public void genera(int numeroCrediti) {
		//List<Esame> esami= ed.getTuttiEsami();
		List<Esame> sottoinsieme =this.miaSoluzioneRicorsiva(numeroCrediti);
	}
	
	public List<Esame> miaSoluzioneRicorsiva( int numeroCrediti) {
		
		
		System.out.println("TODO!");
		
		return null;
	}

}
