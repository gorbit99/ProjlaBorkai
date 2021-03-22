package game_classes;


import java.util.ArrayList;

/**
 * represents a teleporter
 */
public class Teleporter extends SpaceObject {
    /**
     * @param active whether the teleporter is placed
     * @param pair the pair of the teleporter
     * @param parent the parent space object of the teleporter
     * @param billOfMaterials contains the materials that you need to build a teleporter
     */
    private boolean active;
    private Teleporter pair;
    private SpaceObject parent;
    private static BillOfMaterials billOfMaterials;

    /**
     * teleporter constructor
     */
    public Teleporter() {
        TestLogger.EnterFunction("Teleporter.ctor");
        active = false;
        if (billOfMaterials == null) {
            billOfMaterials = new BillOfMaterials();
        }
        TestLogger.ExitFunction();
    }

    /**
     * links the teleporter to the given teleporter
     * @param teleporter the teleporter to be linked
     */
    public void LinkTo(Teleporter teleporter) {
        TestLogger.EnterFunction("Teleporter.LinkTo");
        this.pair = teleporter;
        TestLogger.ExitFunction();
    }

    /**
     * places the teleporter to the given asteroid
     * @param asteroid asteroid to be placed
     */
    public void Place(SpaceObject asteroid) {
        TestLogger.EnterFunction("Teleporter.Place");
        this.active = true;
        this.parent = asteroid;
        this.pair.PairPlaced();
        TestLogger.ExitFunction();
    }

    /**
     * logs that the teleporter's pair is placed
     */
    public void PairPlaced() {
        TestLogger.EnterFunction("Teleporter.PairPlaced");
        this.active = true;
        TestLogger.ExitFunction();
    }

    /**
     * returns the parent space object
     * @return parent space object
     */
    public SpaceObject GetParent() {
        TestLogger.EnterFunction("Teleporter.GetParent");
        TestLogger.ExitFunction();
        return parent;

    }

    /**
     * teleports the given worker to the parent asteroid
     * @param worker worker to be teleported
     */
    public void TeleportWorker(Worker worker) {
        TestLogger.EnterFunction("Teleport.TeleportWorker");
        SpaceObject parent = this.GetParent();
        parent.AddWorker(worker);
        TestLogger.ExitFunction();
    }

    /**
     * creates a teleporter pair
     * @param materials materials to be used to create the teleporter pair
     * @return teleporter list with the pair if its possible to create empty list if not
     */
    public static ArrayList<Teleporter> CreateTeleporterPair(Material[] materials) {
        if (billOfMaterials == null) {
            billOfMaterials = new BillOfMaterials();
        }
        TestLogger.EnterFunction("Teleporter.CreateTeleporterPair");
        ArrayList<Teleporter> teleporters = new ArrayList<>();
        if (billOfMaterials.IsEnough(materials)) {
            Teleporter a = new Teleporter();
            Teleporter b = new Teleporter();
            a.LinkTo(b);
            b.LinkTo(a);
            teleporters.add(a);
            teleporters.add(b);
        }
        TestLogger.ExitFunction();
        return teleporters;
    }

    /**
     * remove the parent space object and gets a new one
     * @param spaceObject space object to be removed
     */
    public void RemoveNeighbour(SpaceObject spaceObject) {
        TestLogger.EnterFunction("Teleporter.ctor");
        System.out.println("Teleport.RemoveNeighbour");
        this.neigbours.remove(spaceObject);
        this.parent = this.neigbours.get(Game.RandomNum(this.neigbours.size()));
        TestLogger.ExitFunction();
    }

    public void AddWorker(Worker worker) {
        TestLogger.EnterFunction("Teleport.AddWorker");
        this.pair.TeleportWorker(worker);
        TestLogger.ExitFunction();
    }

    @Override
    public void RemoveWorker(Worker worker) {
        TestLogger.EnterFunction("I dunno how we got here");
        TestLogger.ExitFunction();
    }

    @Override
    public String toString() {
        return "Teleporter";
    }
}
