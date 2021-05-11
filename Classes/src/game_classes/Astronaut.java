package game_classes;

import graphics.RobotController;
import graphics.SpaceObjectController;

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

    /**
     * Identifier counter
     */
    private static int _id = 1;

    /**
     * Identifier of the player
     */
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

    /**
     * Getter for the id
     * @return the if of the astronaut
     */
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
        changeEvent.firePropertyChange("materialsStored", old, this.position);
    }

    /**
     * places the chosen material back to an asteroid if its core is empty
     */
    public void PlaceMaterial() throws Exception {
        ArrayList<Material> old = (ArrayList<Material>) materialsStored.clone();

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
        ArrayList<Teleporter> old = (ArrayList<Teleporter>) teleporters.clone();
        if (teleporters.isEmpty()) throw new Exception();

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
        new RobotController(this.GetStoredMaterials(), this.position);
    }

    /**
     * creates a teleporter pair from the astronaut's materials
     */
    public void CreateTeleporter() throws Exception {
        if (teleporters.size() > 1) throw new Exception("Couldn't create teleporter");
        ArrayList<Teleporter> teleporter = Teleporter.CreateTeleporterPair(GetStoredMaterials());
        if (teleporter != null)
            this.teleporters = teleporter;
        //SpaceObjectController teleporterController = SpaceObjectController.createTeleporterController(teleporters.get(0));
        //SpaceObjectController teleporterController1 = SpaceObjectController.createTeleporterController(teleporters.get(1));
    }

    /**
     * controls the astronaut's movements
     */
    public void Step() {
        changeEvent.firePropertyChange("ActiveAstronaut", null, this);
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
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();

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
