package game_classes;


import java.util.ArrayList;

public class Teleporter extends SpaceObject {
    private boolean active;
    private Teleporter pair;
    private SpaceObject parent;
    private static BillOfMaterials billOfMaterials;

    private Teleporter() {
        System.out.println("Teleporter.ctor");
        active = false;
    }

    private void LinkTo(Teleporter teleporter) {
        System.out.println("Teleporter.LinkTo");
        this.pair = teleporter;
    }

    public void Place(SpaceObject asteroid) {
        System.out.println("Teleporter.Place");
        this.active = true;
        this.parent = asteroid;
        this.pair.PairPlaced();
    }

    public void PairPlaced() {
        System.out.println("Teleporter.PairPlaced");
        this.active = true;
    }

    public SpaceObject GetParent() {
        System.out.println("Teleporter.GetParent");
        return parent;
    }

    //ezt átírtam privátra mert úgyis csak osztályon belül van használva
    public void TeleportWorker(Worker worker) {
        System.out.println("Teleport.TeleportWorker");
        SpaceObject parent= this.GetParent();
        parent.AddWorker(worker);
    }


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

    //hogy keressünk új szomszédot
    public void RemoveNeighbour(SpaceObject spaceObject) {
        System.out.println("Teleport.RemoveNeighbour");
        this.workers.remove(spaceObject);
        //itt még kéne hozzáadni egy újat
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
