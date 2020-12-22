package org.istic.fr.restlet.database.api;

import java.util.Collection; 
import org.istic.fr.csr.tp5.Zones; 
import org.istic.fr.csr.tp5.Requins; 

/**
 *
 * Interface to the database.
 *
 * @author Marc TSIVANYO
 * 	@author BAH Adama
 *
 */
public interface Database
{ 


    /**
     *  Returns the zones with a given id.
     *
     *  @return the zones
     */
	Zones getZone(int id);
    
    /**
     *  Create requins
     * @param nbrPoisson
     * @param zones 
     */
    Requins createRequins(int nbrPoisson ,Zones [][] zones); 
    
    /**
     *  Returns le nombre de requins encore presents dans la simulation
     *
     *  @return le nombre de requins
     */
    int getRequins(); 


   /**
    *  Returns le nombre de requins encore presents dans la simulation
    *
    *  @return le nombre de requins
    */
    String getRequin(int id);
   
    /**
     *  Returns  Tunas
     *
     *  @return  
     */
    int getTunas();
       
}
