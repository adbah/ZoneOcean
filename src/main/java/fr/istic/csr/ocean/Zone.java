package fr.istic.csr.ocean;

import java.util.List;

public class Zone { 
	private int sardine; 
	private List<PoissonPilote> poissonPilotes;
	private Position position;

	private Requin requin;

	private boolean statusFree =true;//Zone libre
	
	public Zone(int sardine, List<PoissonPilote> poissonPilotes, Position position) {
		super();
		this.sardine = sardine;
		this.poissonPilotes = poissonPilotes;
		this.position = position;
	}
	
	public synchronized void mangerSardine() {
		if (sardine > 0 ){
			sardine--;
			System.out.println(Thread.currentThread().getName()+" Mange il reste "+sardine+" sardine dans la zone ( "+position.getX()+", "+position.getY()+" )");
		}else {
			System.out.println(Thread.currentThread().getName()+" il n'y a plus de sardine dans la zone  ( "+position.getX()+", "+position.getY()+" )");
		}
    }

	public synchronized void entrerRequins(){
		while(statusFree ==false ){
			try {
				System.out.println("Le requins "+Thread.currentThread().getName()+" est en attente pour rentrer dans la zone : ( "+position.getX()+", "+position.getY()+" )");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		statusFree=false;
		notifyAll(); 
	}
	
	public synchronized void sortirRequins(){  
		quitterLaZone();
		System.out.println("Le requins "+Thread.currentThread().getName()+" viens de libérer la zone : ( "+position.getX()+", "+position.getY()+" )");
		notifyAll();
	}

	private void quitterLaZone() { 
		statusFree=true;
		this.requin=null;
	}
	
	
	public int getSardine() {
		return sardine;
	}
	
	public void setSardine(int sardine) {
		this.sardine = sardine;
	}
	public List<PoissonPilote> getPoissonPilotes() {
		return poissonPilotes;
	}
	public void setPoissonPilotes(List<PoissonPilote> poissonPilotes) {
		this.poissonPilotes = poissonPilotes;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}

	public Requin getRequin() {
		return requin;
	}

	public void setRequin(Requin requin) {
		this.requin = requin;
	}

	public boolean isStatusFree() {
		return statusFree;
	}

	public void setStatusFree(boolean statusFree) {
		this.statusFree = statusFree;
	}
	 
 
}
