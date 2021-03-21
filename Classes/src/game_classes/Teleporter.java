package game_classes;


import java.util.ArrayList;

public class Teleporter extends SpaceObject {
    private boolean active;
    private Teleporter pair;
    private SpaceObject parent;
    private static BillOfMaterials billOfMaterials;

    private Teleporter() {
        TestLogger.EnterFunction("Teleporter.ctor");
        active = false;
        TestLogger.ExitFunction();
    }

    private void LinkTo(Teleporter teleporter) {
        TestLogger.EnterFunction("Teleporter.LinkTo");
        this.pair = teleporter;
        TestLogger.ExitFunction();
    }

    public void Place(SpaceObject asteroid) {
        TestLogger.EnterFunction("Teleporter.Place");
        this.active = true;
        this.parent = asteroid;
        this.pair.PairPlaced();
        TestLogger.ExitFunction();
    }

    public void PairPlaced() {
        TestLogger.EnterFunction("Teleporter.PairPlaced");
        this.active = true;
        TestLogger.ExitFunction();
    }

    public SpaceObject GetParent() {
        TestLogger.EnterFunction("Teleporter.GetParent");
        TestLogger.ExitFunction();
        return parent;
    }


    public void TeleportWorker(Worker worker) {
        TestLogger.EnterFunction("Teleport.TeleportWorker");
        TestLogger.ExitFunction();
    }


    public static ArrayList<Teleporter> CreateTeleporterPair(Material[] materials) {
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

    public void RemoveNeighbour(SpaceObject spaceObject) {
        TestLogger.EnterFunction("Teleport.RemoveNeighbour");
        TestLogger.ExitFunction();
    }

    public void AddWorker(Worker worker) {
        TestLogger.EnterFunction("Teleport.AddWorker");
        TestLogger.ExitFunction();
    }

    @Override
    public void RemoveWorker(Worker worker) {
        TestLogger.EnterFunction("Teleporter.RemoveWorker I dunno how we got here");
        TestLogger.ExitFunction();
    }

    @Override
    public String toString() {
        return "Teleporter";
    }
}
