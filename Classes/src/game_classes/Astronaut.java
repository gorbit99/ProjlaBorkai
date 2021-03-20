package game_classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Astronaut extends Worker {
    private Material[] materialsStored;
    private Teleporter[] teleporters;

    public void Mine() {
    }

    public Astronaut() {
        System.out.println("Astronaut.ctor");
        this.materialsStored = new Material[10];
    }

    public void PlaceMaterial(Material material) {
        System.out.println("Astronaut.PlaceMaterial");
    }

    public void PlaceTeleporter() {
        System.out.println("Astronaut.PlaceTeleporter");

    }

    public void CreateRobot() {
        System.out.println("Astronaut.CreateRobot");
    }

    public void CreateTeleporter() {
        System.out.println("Astronaut.CreateTeleporter");
        this.teleporters = Teleporter.CreateTeleporterPair(this.materialsStored);
    }

    public void Step() {
        System.out.println("Astronaut.Step");
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
            //case 7 :this.PlaceMaterial();break;
            default:
                this.Wait();
        }
    }

    public void Explode() {
        System.out.println("Astronaut.Step");
        this.Die();
    }

    public Material[] GetStoredMaterials() {
        System.out.println("Astronaut.Get");
        return this.materialsStored;
    }

    public void Move() {
        System.out.println("Astronaut.Move");
        ArrayList<SpaceObject> neigbours = this.position.GetNeighbours();
        System.out.println("Where do you want to move?");
        for (int i = 0; i < neigbours.size(); i++) {
            String type = String.valueOf(neigbours.get(i).getClass());
            System.out.println(i + 1 + "." + type);
        }
        Scanner scanner = new Scanner(System.in);
        int to = scanner.nextInt();
        scanner.close();
        this.TravelTo(neigbours.get(to - 1));
    }

}
