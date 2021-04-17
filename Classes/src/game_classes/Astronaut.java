package game_classes;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
    private ArrayList<Material> materialsStored;
    private ArrayList<Teleporter> teleporters;

    /**
     * astronaut constructor
     */
    public Astronaut(Asteroid position) {
        super(position);
        this.materialsStored = new ArrayList<>();
        teleporters = new ArrayList<>();
    }

    /**
     * mines an asteroid
     *
     * @throws Exception when there is not enough place for the material.
     */
    public void Mine() throws Exception {
        if (materialsStored.size() >= 10) throw new Exception("Not enough place");
        materialsStored.add(this.position.Mine());
    }

    /**
     * places the chosen material back to an asteroid if its core is empty
     */
    public void PlaceMaterial() {
        Writer writer = new OutputStreamWriter(MockIO.out);
        try {
            for (int i = 0; i < this.materialsStored.size(); i++) {
                if (materialsStored.get(i) != null) {
                    writer.write(i + 1 + "." + materialsStored.get(i).toString());
                }
            }

            writer.write("Which material do you wan to place back?");
            Scanner scanner = new Scanner(MockIO.in);
            int chosen = Integer.parseInt(scanner.nextLine());
            this.position.PlaceMaterial(materialsStored.get(chosen - 1));
        } catch (IOException e) {}
    }

    /**
     * places a teleporter down
     */
    public void PlaceTeleporter() throws Exception {
        if (teleporters.isEmpty()) throw new Exception();
        Writer writer = new OutputStreamWriter(MockIO.out);
        try {
            for (int i = 0; i < this.teleporters.size(); i++) {
                if (teleporters.get(i) != null) {
                    writer.write(i + 1 + "." + teleporters.get(i).toString());
                }
            }
            writer.write("Which teleporter do you wan to place?");
            Scanner scanner = new Scanner(MockIO.in);
            Teleporter t = teleporters.get(Integer.parseInt(scanner.nextLine()) - 1);
            this.teleporters.remove(t);
            t.Place(this.position);
        } catch (IOException e) {}
    }

    /**
     * creates a robot from the astronaut's materials
     */
    public void CreateRobot() throws Exception {
        Robot roby = Robot.CreateRobot(GetStoredMaterials(), this.position);
        if (roby == null) throw new Exception("Couldn't create robot");
    }

    /**
     * creates a teleporter pair from the astronaut's materials
     */
    public void CreateTeleporter() throws Exception {
        if (teleporters.size() > 1) throw new Exception("Couldn't create teleporter");
        this.teleporters = Teleporter.CreateTeleporterPair(GetStoredMaterials());
    }

    /**
     * controls the astronaut's movements
     */
    public void Step() {
        boolean successful = false;
        while (!successful) {
            try {
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
                successful = true;
            } catch (Exception e) {
                System.out.println("szar van");
            }
        }
    }

    /**
     * called when an asteroid is exploded
     */
    public void Explode() {
        this.Die();
    }

    /**
     * returns the materials of the astronaut
     *
     * @return astronauts material
     */
    public ArrayList<Material> GetStoredMaterials() {
        return this.materialsStored;
    }

    /**
     * actor can decide where the astronaut moves and calls travelto
     */
    //TODO mocker
    public void Move() {
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            System.out.println(i + 1 + "." + neighbours.get(i).toString());
        }
        int to = Integer.parseInt(TestLogger.AskQuestion("Where do you want to move?"));

        this.TravelTo(neighbours.get(to - 1));
    }

    public void SetTeleporters(ArrayList<Teleporter> teleporters) {
        this.teleporters = teleporters;
    }

    public void SetStoredMaterials(ArrayList<Material> materials) {
        this.materialsStored = materials;
    }
}
