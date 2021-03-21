package game_classes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * represents an astronaut
 */
public class Astronaut extends Worker {
    /**
     * @param materialsStored contains all the materials that the astronaut has
     * @param teleporters contains the created teleporters
     */
    private final Material[] materialsStored;
    private ArrayList<Teleporter> teleporters;

    /**
     * astronaut constructor
     */
    public Astronaut() {
        TestLogger.EnterFunction("Astronaut.ctor");
        this.materialsStored = new Material[10];
        TestLogger.ExitFunction();
    }

    /**
     * mines an asteroid
     */
    public void Mine() {
        TestLogger.EnterFunction("Astronaut.Mine");
        this.position.Mine();
        TestLogger.ExitFunction();
    }

    /**
     * places the chosen material back to an asteroid if its core is empty
     */
    public void PlaceMaterial() {
        TestLogger.EnterFunction("Astronaut.PlaceMaterial");
        //TODO testlogger.askquestionné
        for (int i = 0; i < this.materialsStored.length; i++) {
            if (materialsStored[i] != null)
                System.out.println(i + 1 + "." + materialsStored[i].toString());
        }
        int chosen = Integer.parseInt(TestLogger.AskQuestion("Which material do you wan to place back?"));
        this.position.PlaceMaterial(materialsStored[chosen - 1]);
        TestLogger.ExitFunction();
    }

    /**
     * places a teleporter down
     */
    public void PlaceTeleporter() {
        TestLogger.EnterFunction("Astronaut.PlaceTeleporter");
        if (teleporters.isEmpty()) {
            TestLogger.ExitFunction();
            return;
        }
        this.teleporters.get(0).Place(this.position);
        this.teleporters.remove(0);
        TestLogger.ExitFunction();
    }

    /**
     * creates a robot from the astronaut's materials
     */
    public void CreateRobot() {
        TestLogger.EnterFunction("Astronaut.CreateRobot");
        Robot roby = Robot.CreateRobot(this.materialsStored);
        if (roby != null) {
            this.position.AddWorker(roby);
        }
        TestLogger.ExitFunction();
    }

    /**
     * creates a teleporter pair from the astronaut's materials
     */
    public void CreateTeleporter() {
        TestLogger.EnterFunction("Astronaut.CreateTeleporter");
        if (teleporters.isEmpty())
            this.teleporters = Teleporter.CreateTeleporterPair(this.materialsStored);
        if (teleporters.isEmpty())
            System.out.println("Error");
        TestLogger.ExitFunction();
    }

    /**
     * controls the astronaut's movements
     */
    public void Step() {
        TestLogger.EnterFunction("Astronaut.Step");
        System.out.println("1. Wait");
        System.out.println("2. Move");
        System.out.println("3. Mine");
        System.out.println("4. Drill");
        System.out.println("5. Create Robot");
        System.out.println("6. Create Teleporter");
        System.out.println("7. Place Teleporter");
        System.out.println("8. Place Material");
        int to = Integer.parseInt(TestLogger.AskQuestion("Which movement you want to make"));
        to--;
        switch (to) {
            case 1:
                this.Move();
                break;
            case 2:
                this.Mine();
                break;
            case 3:
                this.Drill();
                break;
            case 4:
                this.CreateRobot();
                break;
            case 5:
                this.CreateTeleporter();
                break;
            case 6:
                this.PlaceTeleporter();
                break;
            case 7:
                this.PlaceMaterial();
                break;
            default:
                this.Wait();
                break;
        }
        TestLogger.ExitFunction();
    }

    /**
     * called when an asteroid is exploded
     */
    public void Explode() {
        TestLogger.EnterFunction("Astronaut.Step");
        this.Die();
        TestLogger.ExitFunction();
    }

    /**
     * returns the materials of the astronaut
     * @return astronauts material
     */
    public Material[] GetStoredMaterials() {
        TestLogger.EnterFunction("Astronaut.Get");
        TestLogger.ExitFunction();
        return this.materialsStored;
    }

    /**
     * actor can decide where the astronaut moves and calls travelto
     */
    public void Move() {
        TestLogger.EnterFunction("Astronaut.Move");
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            System.out.println(i + 1 + "." + neighbours.get(i).toString());
        }
        int to = Integer.parseInt(TestLogger.AskQuestion("Where do you want to move?"));

        this.TravelTo(neighbours.get(to - 1));
        TestLogger.ExitFunction();
    }
}
