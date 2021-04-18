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
            ArrayList<Material> materials = new ArrayList<Material>();
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
        //todo nézzétek meg az aktívot
        //this.parent = asteroid;
        this.AddNeighbour(asteroid);
        if (this.pair != null) {
            this.pair.PairPlaced();
            if (pair.active)
                this.active = true;
        }
        asteroid.AddNeighbour(this);
        AsteroidField.GetInstance().AddSpaceObject(this);//Hozzáadjuk, hogy tudjon Move-olódni.
    }

    /**
     * logs that the teleporter's pair is placed
     */
    public void PairPlaced() {
        if (neighbours.size() != 0)//van szomszédja, azaz lehelyezték
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
            ArrayList<Material> createMaterials = new ArrayList<Material>();
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
        return null;//todo specifikációba ez van.
    }

    /**
     * remove the parent space object and gets a new one
     *
     * @param spaceObject space object to be removed
     */
    public void RemoveNeighbour(SpaceObject spaceObject) {

        //todo pointer összehasonlítás, légyszi nézzetek rá jó-e. Jelenleg csak akkor fut végtelenségig, ha egy asteroida marad a játékban. Ha ilyen lehet akk szopó van.
        int random;
        do {
            random = Game.RandomNum(this.neighbours.size());
        } while (this.GetParent() == AsteroidField.GetInstance().GetObjects().get(random) ||
                pair.GetParent() == AsteroidField.GetInstance().GetObjects().get(random));
        this.neighbours.remove(spaceObject);
        this.AddNeighbour(this.neighbours.get(random));
    }

    public void AddWorker(Worker worker) {
        this.pair.TeleportWorker(worker);
    }

    @Override
    public void RemoveWorker(Worker worker) {

    }

    @Override
    public void Move() {
        if (this.isBroken)
            this.RemoveNeighbour(this.GetParent());
    }

    @Override
    public void HandleSolarStorm() {
        isBroken = true;
    }

    @Override
    public Material GetCore() {
        return null;
    }

    @Override
    public String toString() {
        return "Teleporter";
    }

    public boolean GetBroken() {
        return isBroken;
    }

    public void SetBroken(boolean broken) {
        isBroken = broken;
    }

    public Teleporter GetPair() {
        return pair;
    }
}
