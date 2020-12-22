package org.istic.fr.csr.tp5;

import java.util.Random;

public class Ocean {
	
	/* Constantes */
	 
	 private static final int NB_ZONES = 16;
	private  static final int NB_REQ = 10;
	private static  PoisonPilotes p = null;
	

	 /* Attributs */
	 
	  public static  int N = 4 ;
	  private Zones [][] zones = new Zones[N][N];
      private static Requins[] requin = new Requins[NB_REQ ];
	 

   public Ocean() {
	 // Instanciation des Zones 
	   Random r = new Random();
	  for(int i= 0 ; i<NB_REQ ; i++) {
		  for(int lig= 0 ; lig< N; lig++) {
			  for(int col= 0 ; col< zones[lig].length; col++) {
				   lig = r.nextInt(N);
				   col = r.nextInt(N);
				  zones[lig][col]= new Zones (requin[i], 8); 
			  }     
		 }
		 
	  }
	  
	  //Instanciation des requins 
	  for(int i = 0; i < NB_REQ; i++)
		{
		  requin[i] = new Requins(4, this.zones) ;
		}
	  for(int i = 0; i < NB_REQ; i++)
	{
		  
		}
	   //Instanciation des poissons pilotes
	  for(int i = 0; i < NB_REQ; i++) {
		  p  = new PoisonPilotes(requin[i]);
	  }
	      
       
      }
	   public static void main(String[] args) throws InterruptedException { 
		   
		   Ocean o = new Ocean();
		   
		   for (int i = 0 ; i<NB_REQ ; i++ ) {
			   requin[i].start();
		   }
		   p.start();
	   }
			
			
	
	
}
