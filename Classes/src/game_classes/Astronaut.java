package game_classes;

import graphics.RobotController;

import java.util.ArrayList;

/**
 * represents an astronaut
 */
public class Astronaut extends Worker {

    /**
     * Contains all the materials that the astronaut has
     */
    private final ArrayList<Material> materialsStored;
    /**
     * Contains the created teleporters
     */
    private ArrayList<Teleporter> teleporters;

    private static int _id = 1;

    private int astronautId;

    /**
     * astronaut constructor
     */
    public Astronaut(Asteroid position) {
        super(position);
        this.materialsStored = new ArrayList<>();
        teleporters = new ArrayList<>();
        this.astronautId = _id;
        _id++;
    }

    public int getAstronautId() {
        return astronautId;
    }

    /**
     * mines an asteroid
     *
     * @throws Exception when there is not enough place for the material.
     */
    public void Mine() throws Exception {
        if (materialsStored.size() >= 10) throw new Exception("Not enough place");
        ArrayList<Material> old = (ArrayList<Material>) materialsStored.clone();
        materialsStored.add(this.position.Mine());
        changeEvent.firePropertyChange("materialsStored", old, materialsStored);
    }

    /**
     * places the chosen material back to an asteroid if its core is empty
     */
    public void PlaceMaterial() throws Exception {
        //todo mock
        ArrayList<Material> old = (ArrayList<Material>) materialsStored.clone();
        for (int i = 0; i < this.materialsStored.size(); i++) {
            if (materialsStored.get(i) != null) {
                MockIO.out.println(i + 1 + "." + materialsStored.get(i).toString());
            }
        }
        //int chosen = Integer.parseInt(TestLogger.AskQuestion("Which material do you want to place back?"));
        if (this.position.PlaceMaterial(materialsStored.get(0))) {
            materialsStored.remove(0);
        } else {
            throw new Exception("Couldn't place material");
        }
        changeEvent.firePropertyChange("materialsStored", old, materialsStored);
    }

    /**
     * places a teleporter down
     */
    public void PlaceTeleporter() throws Exception {
        //todo mock
        ArrayList<Teleporter> old = (ArrayList<Teleporter>) teleporters.clone();
        if (teleporters.isEmpty()) throw new Exception();
        for (int i = 0; i < this.teleporters.size(); i++) {
            if (teleporters.get(i) != null) {
                MockIO.out.println(i + 1 + "." + teleporters.get(i).toString());
            }
        }
        int chosen = Integer.parseInt(TestLogger.AskQuestion("Which teleporter do you want to place?"));
        Teleporter t = teleporters.get(chosen - 1);
        this.teleporters.remove(t);
        t.Place(this.position);
        changeEvent.firePropertyChange("teleporters", old, teleporters);
    }

    /**
     * creates a robot from the astronaut's materials
     */
    public void CreateRobot() throws Exception {
        //Robot roby = Robot.CreateRobot(GetStoredMaterials(), this.position);
        //if (roby == null) throw new Exception("Couldn't create robot");
        new RobotController(this.position);
    }

    /**
     * creates a teleporter pair from the astronaut's materials
     */
    public void CreateTeleporter() throws Exception {
        if (teleporters.size() > 1) throw new Exception("Couldn't create teleporter");
        ArrayList<Teleporter> teleporter = Teleporter.CreateTeleporterPair(GetStoredMaterials());
        if (teleporter != null)
            this.teleporters = teleporter;
    }

    /**
     * controls the astronaut's movements
     */
    public void Step() {
        changeEvent.firePropertyChange("ActiveAstronaut", null, this);
        System.out.println("Astronaut" + astronautId);
        boolean successful = true;
        MockIO.in.addInput("2\n");
        MockIO.in.addInput("1\n");
        while (!successful) {
            try {
                MockIO.out.println("1. Wait");
                MockIO.out.println("2. Move");
                MockIO.out.println("3. Mine");
                MockIO.out.println("4. Drill");
                MockIO.out.println("5. Create Robot");
                MockIO.out.println("6. Create Teleporter");
                MockIO.out.println("7. Place Teleporter");
                MockIO.out.println("8. Place Material");
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
                MockIO.out.println("Action could not be executed, chose an other one");
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
     * actor can decide where the astronaut moves and calls travelTo
     */
    public void Move() {
        SpaceObject old = position;
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();
        /*for (int i = 0; i < neighbours.size(); i++) {
            MockIO.out.println(i + 1 + "." + neighbours.get(i).toString());
        }
        int to = Integer.parseInt(TestLogger.AskQuestion("Where do you want to move?"));
*/
        this.TravelTo(neighbours.get(Game.RandomNum(neighbours.size() - 1)));


        changeEvent.firePropertyChange("position", old, position);

    }

    /**
     * Gets the collection of teleporters this astronaut owns
     *
     * @return the teleporters this astronaut owns
     */
    public ArrayList<Teleporter> GetTeleporters() {
        return teleporters;
    }


}
