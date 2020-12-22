package org.istic.fr.csr.tp5;

public class PoisonPilotes extends Thread {
	
	private  Requins requin ;
	private int nbreRequin;
	private boolean requinLibre= true;
	
	public  PoisonPilotes(Requins requin) {
		this.requin = requin;
	}
	// permet à un poisson pilote de s'attacher à un requin
   public synchronized void attacher() {
	 if(requinLibre) {
			requin.attacher();
	System.out.println(Thread.currentThread().getName() + " s'est attaché à un requin dans sa zone courante " );

     }
  }
   // permet de se détache du requin
	public synchronized void seDeplacer() {
		Zones courant =  requin.getRandom();
		courant=requin.getSuivant();
	   requin.detacher();
	System.out.println(Thread.currentThread().getName() + " s'est dettaché du requin dans la zone suivante " );
  
	}
	public void run (){
		   attacher();	
		   seDeplacer();
	}	
	
}
