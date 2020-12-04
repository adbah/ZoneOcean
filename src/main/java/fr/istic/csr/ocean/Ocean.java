package fr.istic.csr.ocean;

public class Ocean extends Thread{
	private  int size;
	private Zone[][] zones;
	
		
	public Ocean(int size, Zone[][] zones) {
		super();
		this.size = size;
		this.zones = new Zone[this.size][this.size];
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Zone[][] getZones() {
		return zones;
	}
	public void setZones(Zone[][] zones) {
		this.zones = zones;
	}
	
	public Zone getZone(Position position) {
		return zones[position.getX()][position.getY()];
	}
	
	public void setZone(Position position, Zone zone) {
		this.zones[position.getX()][position.getY()]=zone;
	}
	
	
}
