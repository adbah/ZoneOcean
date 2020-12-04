package fr.istic.csr.ocean;

public class Requin extends Thread {
 
	
	public static int LIFETIME=10;
	
	public static int NBRE_PLACE_MAX=10;
	
	private int taillePlace=0;
	
	private Zone zone; 
	
	private Position position;
	
	private int placeDispo; //Pour poisson pilote
	
	private int vieRestante=LIFETIME;

	public Requin(int id, int taillePlace, Zone zone, Position position) {
		super(); 
		this.taillePlace = taillePlace;
		this.zone = zone;
		this.position = position; 
		placeDispo=NBRE_PLACE_MAX;
	}
	
	public synchronized void transporterPoissionPilote() {
		while (taillePlace == 0) {
			try {
				System.out.println("Le requins"+ Thread.currentThread().getName()+" ne dispose plus de place pour transporter");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		taillePlace--;
		notifyAll();
	}

	public synchronized void deposerPoissonPilote() {
		if (taillePlace  < NBRE_PLACE_MAX) {
			taillePlace++;
			System.out.println("Le requins  "+ Thread.currentThread().getName()  + "ne dispose une place  de : "+taillePlace );
		}
		notifyAll();
	}
	
	 

	public void rentrerZone() {
		
		
		
		
	}
	
	
	
	public void mangerSardine() {
		this.zone.mangerSardine();
	}

	public synchronized void sortirZone() {
		this.zone.sortirRequins();
		notifyAll();
	}


	public static int getLIFETIME() {
		return LIFETIME;
	}

	public static void setLIFETIME(int lIFETIME) {
		LIFETIME = lIFETIME;
	}

	public static int getNBRE_PLACE_MAX() {
		return NBRE_PLACE_MAX;
	}

	public static void setNBRE_PLACE_MAX(int nBRE_PLACE_MAX) {
		NBRE_PLACE_MAX = nBRE_PLACE_MAX;
	}

	public int getTaillePlace() {
		return taillePlace;
	}

	public void setTaillePlace(int taillePlace) {
		this.taillePlace = taillePlace;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getPlaceDispo() {
		return placeDispo;
	}

	public void setPlaceDispo(int placeDispo) {
		this.placeDispo = placeDispo;
	}

	public int getVieRestante() {
		return vieRestante;
	}

	public void setVieRestante(int vieRestante) {
		this.vieRestante = vieRestante;
	}

	public void prendreUnpossoinPilote() { 
		placeDispo--;
		
	}
	
	 
}
