package org.istic.fr.csr.tp5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Requins extends Thread {
		
	private static  int MAX_REQUINS=1 ;
	private static int MAX_POISSON =20 ;
	
	
  /* Atributs  */
	private int nbrPoisson;
	private Zones  precedent ;
    private Zones  suivant;
	private Zones  dessus;
	private Zones  dessous;
    private int nbZones ;
	private Zones  courante;
	private Zones [][] zones ;
	
	 public Requins(int nbrPoisson ,Zones [][] zones ) {
		super();
		/*this.precedent = precedent;
		this.suivant = suivant;
		this.dessus = dessus;
		this.dessous = dessous;
	    this.courante = courante;*/
		this.zones = zones;
		this.nbrPoisson=nbrPoisson;
	}

  public void manger() {
          this.getRandom().baisseSardine();
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
/* choisit les zones de façon aléatoire  */
  
  public Zones getRandom() {
		int lig =  (new Random()).nextInt(Ocean.N);
		int col =  (new Random()).nextInt(Ocean.N);

		return this.zones[lig][col] ;
  }
  
 public synchronized void attacher() {
	 if (nbrPoisson >= MAX_POISSON ) {
			 try {
				   wait();
			   }catch (InterruptedException e) {
				   e.printStackTrace();
			   }
		     
		   }
		
		nbrPoisson ++; 
    }
//Retourne la Zone suivante du requin 
	 public Zones getSuivant() {
		return suivant;
	}
	
	public void setSuivant(Zones suivant) {
		this.suivant = suivant;
	}
	
	public  Zones getCourante() {
		return courante;
	}
	// Retourne la Zone courante du requin
	public  void setCourante(Zones courante) {
		courante = courante;
	}
	
	public synchronized void detacher() {
			  notify();
			  nbrPoisson--;		
	}
	
   
	public void run (){
	    try {
	    	
			this.getRandom().entrer();
			//this.detacher();
			this.manger();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // manger
	  this.getRandom().sortir();

	}
	
	public int resteVie() {
		return (MAX_POISSON-nbrPoisson);
	}
	
	public boolean resteEnVie() {
		 if(resteVie()>0) {
			 return true;
		 }
		 
		 return false;
	}

}
