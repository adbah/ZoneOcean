package fr.istic.csr.ocean;

public class PoissonPilote extends Thread{
	// Zone
	
	
	public  static int LIFETIME=10;
	
	private Position position;
	
	private Requin requin;
	
	private Zone zone;
	
	private int vieRestante;

	
	public PoissonPilote(Position position, Zone zone) {
		super();
		this.position = position;
		this.zone = zone;
		this.vieRestante=LIFETIME;
	}
	
	public synchronized void attacherRequin() {
		while(this.zone.isStatusFree()==false) {
			this.zone.getRequin().transporterPoissionPilote();
			seDeplacer();
		}
    }
	
	public synchronized void lacherRequin() {
		this.zone.getRequin().deposerPoissonPilote();
		this.requin=null;
    }

	
	public void seDeplacer() {
		this.vieRestante--;
		this.requin=this.zone.getRequin();
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Requin getRequin() {
		return requin;
	}

	public void setRequin(Requin requin) {
		this.requin = requin;
	}

	public int getVieRestante() {
		return vieRestante;
	}
 
	 
	
	public void run() {
		for (int i = 4; i>0; i--) {
			attacherRequin(); 
		}
	}

	
}
