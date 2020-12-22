package org.istic.fr.restlet.database.api.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.istic.fr.csr.tp5.Requins;
import org.istic.fr.csr.tp5.Zones;
import org.istic.fr.restlet.database.api.Database; 

/**
 *
 * In-memory database 
 *
 * @author Marc TSIVANYO
 * @author BAH Adama
 *
 */
public class InMemoryDatabase implements Database
{

    /** User count (next id to give).*/
    private int zoneCount_;
    private int requinCount_;

    /** User Hashmap. */
    Map<Integer, Zones> zones_;
    Map<Integer, Requins> requins_;


    public InMemoryDatabase()
    {
    	zones_ = new HashMap<Integer, Zones>();
    	requins_ = new HashMap<Integer, Requins>();
    }

  
    @Override
    public Zones getZone(int id)
    {
        return zones_.get(id);
    }

	@Override
	public synchronized  Requins createRequins(int nbrPoisson,Zones [][] zones) { 
		Requins requin = new Requins(nbrPoisson, zones); 
		requins_.put(requinCount_, requin);
		requinCount_ ++;
        return requin;
	}
	/**
	 *  recuperer le nombre de requins encore presents dans la simulation
	 */
	@Override
	public int getRequins() {  
		int somme=0; 
		Collection<Requins> requins=  requins_.values(); 
		for(Requins requin:requins ) {
			if(requin.resteEnVie()) {
				somme++;
			}
		}
		return somme;
	}

	@Override
	public String getRequin(int id) { 
		if(requins_.get(id)!=null) {
			return "Zone du requin :"+requins_.get(id).getCourante().toString()+" et lui reste  :"+ requins_.get(id).resteVie()+" vie ";
		} 
		return ""; 
	}

	@Override
	public int getTunas() {
		int somme=0; 
		Collection<Zones> zones=  zones_.values();
		for(Zones zone:zones ) {
			somme+=zone.getNbreSardinesDispo();
		}
		return 0;
	}
 
}
