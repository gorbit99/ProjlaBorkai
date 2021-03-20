package game_classes;


import java.util.ArrayList;

public class Teleporter extends SpaceObject {
	private boolean active;
	private Teleporter pair;
	private Asteroid parent;
	private BillOfMaterials billOfMaterials;

	public void LinkTo(Teleporter teleporter) {
	}
	
	public void Place(SpaceObject asteroid) {
	}
	
	public void PairPlaced() {
	}
	
	public Asteroid GetParent() {
	}

	public boolean IsActive(){
		return active;
	}
	

	
	public void TeleportWorker(Worker worker) {
	}


	
	public static ArrayList<Teleporter> CreateTeleporterPair(Material[] materials) {
	}
	
	public void RemoveNeighbour(SpaceObject spaceObject) {
	}
	
	public void AddWorker(Worker worker) {
	}

	@Override
	public String toString(){
		return "Teleporter";
	}
}
