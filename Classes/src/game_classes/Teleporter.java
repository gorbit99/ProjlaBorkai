package game_classes;



public class Teleporter extends SpaceObject {
	private boolean active;
	private Teleporter pair;
	private Asteroid parent;
	private BillOfMaterials billOfMaterials;

	public void LinkTo(Teleporter teleporter) {
	}
	
	public void Place(Asteroid asteroid) {
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


	
	public static Teleporter[] CreateTeleporterPair(Material[] materials) {
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
