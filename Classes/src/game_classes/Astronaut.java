package game_classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Astronaut extends Worker {
    private Material[] materialsStored;
    private ArrayList<Teleporter> teleporters;

    public void Mine() {
        TestLogger.EnterFunction("Astronaut.Mine");
        TestLogger.ExitFunction();
    }

    public Astronaut() {
        TestLogger.EnterFunction("Astronaut.ctor");
        this.materialsStored = new Material[10];
        TestLogger.ExitFunction();
    }

    public void PlaceMaterial(Material material) {
        TestLogger.EnterFunction("Astronaut.PlaceMaterial");
        TestLogger.ExitFunction();
    }

    //nem tudom mennyire jó ötlet a castolás
    public void PlaceTeleporter() {
        TestLogger.EnterFunction("Astronaut.PlaceTeleporter");
        if (teleporters.isEmpty()) {
            TestLogger.ExitFunction();
            return;
        }
        this.teleporters.get(0).Place(this.position);
        TestLogger.ExitFunction();
    }

    public void CreateRobot() {
        TestLogger.EnterFunction("Astronaut.CreateRobot");
        Robot roby = Robot.CreateRobot(this.materialsStored);
        if (roby != null){
            this.position.AddWorker(roby);
        }
        TestLogger.ExitFunction();
    }

    public void CreateTeleporter() {
        TestLogger.EnterFunction("Astronaut.CreateTeleporter");
        if (teleporters.isEmpty())
            this.teleporters = Teleporter.CreateTeleporterPair(this.materialsStored);
        if (teleporters.isEmpty())
            System.out.println("Error");
        TestLogger.ExitFunction();
    }

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
        Scanner scanner = new Scanner(System.in);
        int to = scanner.nextInt();
        scanner.close();
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
                //this.PlaceMaterial();
                break;
            default:
                this.Wait();
        }
        TestLogger.ExitFunction();
    }

    public void Explode() {
        TestLogger.EnterFunction("Astronaut.Step");
        this.Die();
        TestLogger.ExitFunction();
    }

    public Material[] GetStoredMaterials() {
        TestLogger.EnterFunction("Astronaut.Get");
        TestLogger.ExitFunction();
        return this.materialsStored;
    }

    public void Move() {
        TestLogger.EnterFunction("Astronaut.Move");
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();
        System.out.println("Where do you want to move?");
        for (int i = 0; i < neighbours.size(); i++) {
            System.out.println(i + 1 + "." + neighbours.get(i).toString());
        }
        Scanner scanner = new Scanner(System.in);
        int to = scanner.nextInt();
        scanner.close();
        this.TravelTo(neighbours.get(to - 1));
        TestLogger.ExitFunction();
    }

}
