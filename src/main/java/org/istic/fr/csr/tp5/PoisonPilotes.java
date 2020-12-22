package org.istic.fr.csr.tp5;

public class PoisonPilotes extends Thread {
	
	private  Requins requin ;
	private int nbreRequin;
	private boolean requinLibre= true;
	
	public  PoisonPilotes(Requins requin) {
		this.requin = requin;
	}
	// permet � un poisson pilote de s'attacher � un requin
   public synchronized void attacher() {
	 if(requinLibre) {
			requin.attacher();
	System.out.println(Thread.currentThread().getName() + " s'est attach� � un requin dans sa zone courante " );

     }
  }
   // permet de se d�tache du requin
	public synchronized void seDeplacer() {
		Zones courant =  requin.getRandom();
		courant=requin.getSuivant();
	   requin.detacher();
	System.out.println(Thread.currentThread().getName() + " s'est dettach� du requin dans la zone suivante " );
  
	}
	public void run (){
		   attacher();	
		   seDeplacer();
	}	
	
}
