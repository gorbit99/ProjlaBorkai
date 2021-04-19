package game_classes;


import java.util.ArrayList;

/**
 * represents a teleporter
 */
public class Teleporter extends SpaceObject {
    /**
     * active whether the teleporter is placed
     * isBroken signs whether the teleporter got crazy
     * pair the pair of the teleporter
     * parent the parent space object of the teleporter
     * billOfMaterials contains the materials that you need to build a teleporter
     */
    private boolean active;
    private boolean isBroken;
    private Teleporter pair;
    private static BillOfMaterials billOfMaterials;

    /**
     * teleporter constructor
     */
    public Teleporter() {
        active = false;
        if (billOfMaterials == null) {
            ArrayList<Material> materials = new ArrayList<>();
            materials.add(new Iron());
            materials.add(new Iron());
            materials.add(new Ice());
            materials.add(new Uranium());
            billOfMaterials = new BillOfMaterials(materials);
        }
    }

    /**
     * links the teleporter to the given teleporter
     *
     * @param teleporter the teleporter to be linked
     */
    public void LinkTo(Teleporter teleporter) {
        this.pair = teleporter;
    }

    /**
     * places the teleporter to the given asteroid
     *
     * @param asteroid asteroid to be placed
     */
    public void Place(SpaceObject asteroid) {
        this.AddNeighbour(asteroid);
        if (this.pair != null) {
            this.pair.PairPlaced();
            if (pair.active)
                this.active = true;
        }
        asteroid.AddNeighbour(this);
        AsteroidField.GetInstance().AddSpaceObject(this);
    }

    /**
     * logs that the teleporter's pair is placed
     */
    public void PairPlaced() {
        if (neighbours.size() != 0)
            active = true;
    }

    /**
     * returns the parent space object
     *
     * @return parent space object
     */
    public SpaceObject GetParent() {
        //return parent;
        if (neighbours.isEmpty()) {
            return null;
        }
        return neighbours.get(0);
    }

    /**
     * teleports the given worker to the parent asteroid
     *
     * @param worker worker to be teleported
     */
    public void TeleportWorker(Worker worker) {
        SpaceObject parent = this.GetParent();
        parent.AddWorker(worker);
    }


    /**
     * creates a teleporter pair
     *
     * @param materials materials to be used to create the teleporter pair
     * @return teleporter list with the pair if its possible to create empty list if not
     */
    public static ArrayList<Teleporter> CreateTeleporterPair(ArrayList<Material> materials) {
        if (billOfMaterials == null) {
            ArrayList<Material> createMaterials = new ArrayList<>();
            createMaterials.add(new Iron());
            createMaterials.add(new Iron());
            createMaterials.add(new Ice());
            createMaterials.add(new Uranium());
            billOfMaterials = new BillOfMaterials(createMaterials);
        }
        ArrayList<Teleporter> teleporters = new ArrayList<>();
        if (billOfMaterials.IsEnough(materials)) {
            Teleporter a = new Teleporter();
            Teleporter b = new Teleporter();
            a.LinkTo(b);
            b.LinkTo(a);
            teleporters.add(a);
            teleporters.add(b);
            return teleporters;
        }
        return null;
    }

    /**
     * remove the parent space object and gets a new one
     *
     * @param spaceObject space object to be removed
     */
    public void RemoveNeighbour(SpaceObject spaceObject) {
        int random;
        do {
            random = Game.RandomNum(this.neighbours.size());
        } while (this.GetParent() == AsteroidField.GetInstance().GetObjects().get(random) ||
                pair.GetParent() == AsteroidField.GetInstance().GetObjects().get(random));
        this.neighbours.remove(spaceObject);
        this.AddNeighbour(this.neighbours.get(random));
    }

    /**
     * starts the teleporting of a worker
     *
     * @param worker worker to be teleported
     */
    public void AddWorker(Worker worker) {
        this.pair.TeleportWorker(worker);
    }


    /**
     * does nothing
     *
     * @param worker worker to be removed from workers list
     */
    @Override
    public void RemoveWorker(Worker worker) {

    }

    /**
     * if the teleporter is broken it changes parent asteroid
     */
    @Override
    public void Move() {
        if (this.isBroken)
            this.RemoveNeighbour(this.GetParent());
    }

    /**
     * if a teleporter gets into a solar storm it gets broken
     * sets broken to true
     */
    @Override
    public void HandleSolarStorm() {
        isBroken = true;
    }

    /**
     * does nothing
     *
     * @return null because the teleporter does not have a core
     */
    @Override
    public Material GetCore() {
        return null;
    }

    /**
     * To string method of teleporter
     *
     * @return The string representation of the teleporter
     */
    @Override
    public String toString() {
        return "Teleporter";
    }

    /**
     * \
     * Returns if the teleporter is broken
     *
     * @return Is the teleporter broken
     */
    public boolean IsBroken() {
        return isBroken;
    }

    /**
     * sets broken to the given param
     *
     * @param broken the value will be set to the isBroken
     */
    public void SetBroken(boolean broken) {
        isBroken = broken;
    }

    /**
     * returns the pair of the teleporter
     *
     * @return te pair of the teleporter
     */
    public Teleporter GetPair() {
        return pair;
    }
}
