package org.istic.fr.csr.tp5;

import java.util.Collection;

public class Zones {
	
	/* Constantes associees à une zone*/
	
	private static  int NBR_SARDINES_INI= 10;
    
	private boolean zoneLibre;
	 
	private  int nbreSardinesDispo;
	private  int nbreRequin;
	private Requins req ;

	 public Zones( Requins req , int nbreSardinesDispo ) {
		 this.zoneLibre= true;
		 this.req= req;
		 this.nbreSardinesDispo = nbreSardinesDispo;
		  
	} 
/* le nombre de sardine baisse lorsqu'ils sont mangés par un requin*/
  
	public synchronized void baisseSardine() {
		
		if (nbreSardinesDispo == 0) {
			   try {
				   wait();
			   }catch (InterruptedException e) {
				   e.printStackTrace();
			   }
		   }
		System.out.println(Thread.currentThread().getName() + " est entrain de manger " );

		nbreSardinesDispo--;
		System.out.println( Thread.currentThread().getName() + " le nombre de Sardines disponible " + this.nbreSardinesDispo);
		
	}
	// Entrer dans une zone 

	synchronized void entrer() throws InterruptedException{
		   while (!zoneLibre){
			   try {
				   wait();
			   }catch (InterruptedException e) {
				   e.printStackTrace();
			   }
		     
		   }
		   zoneLibre=true;
		   
          System.out.println(Thread.currentThread().getName() + " Entre de sa zone de cycle " + this);

		 }
	
	synchronized void sortir (){
		   notify();
		   System.out.println(Thread.currentThread().getName() + " Sort de sa zone de cycle précedent");
		 }

	public static int getNBR_SARDINES_INI() {
		return NBR_SARDINES_INI;
	}

	public boolean isZoneLibre() {
		return zoneLibre;
	}

	public int getNbreSardinesDispo() {
		return nbreSardinesDispo;
	}

	public int getNbreRequin() {
		return nbreRequin;
	}

	public Requins getReq() {
		return req;
	}
  
	
}
