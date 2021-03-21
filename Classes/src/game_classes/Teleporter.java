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
    private Teleporter() {
        System.out.println("Teleporter.ctor");
        active = false;
    }

    /**
     * links the teleporter to the given teleporter
     * @param teleporter the teleporter to be linked
     */
    private void LinkTo(Teleporter teleporter) {
        System.out.println("Teleporter.LinkTo");
        this.pair = teleporter;
    }

    /**
     * places the teleporter to the given asteroid
     * @param asteroid asteroid to be placed
     */
    public void Place(SpaceObject asteroid) {
        System.out.println("Teleporter.Place");
        this.active = true;
        this.parent = asteroid;
        this.pair.PairPlaced();
    }

    /**
     * logs that the teleporter's pair is placed
     */
    public void PairPlaced() {
        System.out.println("Teleporter.PairPlaced");
        this.active = true;
    }

    /**
     * returns the parent space object
     * @return parent space object
     */
    public SpaceObject GetParent() {
        System.out.println("Teleporter.GetParent");
        return parent;
    }

    /**
     * teleports the given worker to the parent asteroid
     * @param worker worker to be teleported
     */
    public void TeleportWorker(Worker worker) {
        System.out.println("Teleport.TeleportWorker");
        SpaceObject parent = this.GetParent();
        parent.AddWorker(worker);
    }

    /**
     * creates a teleporter pair
     * @param materials materials to be used to create the teleporter pair
     * @return teleporter list with the pair if its possible to create empty list if not
     */
    public static ArrayList<Teleporter> CreateTeleporterPair(Material[] materials) {
        System.out.println("Teleporter.CreateTeleporterPair");
        ArrayList<Teleporter> teleporters = new ArrayList<>();
        if (billOfMaterials.IsEnough(materials)) {
            Teleporter a = new Teleporter();
            Teleporter b = new Teleporter();
            a.LinkTo(b);
            b.LinkTo(a);
            teleporters.add(a);
            teleporters.add(b);
        }
        return teleporters;
    }

    /**
     * remove the parent space object and gets a new one
     * @param spaceObject space object to be removed
     */
    public void RemoveNeighbour(SpaceObject spaceObject) {
        System.out.println("Teleport.RemoveNeighbour");
        this.neigbours.remove(spaceObject);
        this.parent = this.neigbours.get(Game.RandomNum(this.neigbours.size()));

    }

    public void AddWorker(Worker worker) {
        System.out.println("Teleport.AddWorker");
        this.pair.TeleportWorker(worker);
    }

    @Override
    public void RemoveWorker(Worker worker) {
        System.out.println("I dunno how we got here");
    }

    @Override
    public String toString() {
        return "Teleporter";
    }
}
