package game_classes;


import java.util.ArrayList;
import java.util.Random;

/**
 * represent an asteroid. Extends SpaceObject.
 */
public class Asteroid extends SpaceObject {
    /**
     * The core of the asteroid.
     */
    private Material core;
    /**
     * The distance between the sun and the asteroid
     */
    private float distanceFromSun;
    /**
     * The number of layers not drilled through in the asteroid's crust
     */
    private int layers;


    /**
     * The constructor of the asteroid.
     */
    public Asteroid() {
        this.layers = Game.getRandomGenerator().nextInt(3) + 1;
        this.distanceFromSun = Game.getRandomGenerator().nextFloat() * 5;
        this.core = null;
    }

    /**
     * handles, when someone drills the asteroid
     *
     * @throws Exception when there are no layers left to drill
     */
    public void Drill() throws Exception {
        int oldValue = layers;
        if (layers == 0) throw new Exception("No layers left");
        if (layers > 0) layers--;
        int newValue = layers;
        changeEvent.firePropertyChange("layers", oldValue, newValue);
        if (layers == 0 && IsCloseToSun() && core != null)
            core.HandleCloseToSun(this);
    }

    /**
     * Handles when its under mining.
     *
     * @return the material in the asteroid if you can mine this, null otherwise.
     */
    public Material Mine() {
        if (layers != 0 || core == null) return null;
        Material temp = core;
        SetCore(null);
        changeEvent.firePropertyChange("core", temp, null);
        return temp;
    }

    /**
     * Places material to the core. (if it can be done)
     *
     * @param material This will be the core
     * @return true, if the method has been done.
     */
    public boolean PlaceMaterial(Material material) {
        if (core == null) {
            SetCore(material);
            if (distanceFromSun <= 2.5f) {
                core.HandleCloseToSun(this);
            }
            return true;
        }
        return false;
    }

    /**
     * Changes the distance from the sun.
     */
    public void Move() {
        float previous = distanceFromSun;
        Random rnd = new Random();
        do {
            distanceFromSun = rnd.nextFloat() * 5;
        } while (Math.abs(previous - distanceFromSun) < 0.01f);
        changeEvent.firePropertyChange("core", previous, distanceFromSun);
    }

    /**
     * Handles, when asteroid explodes.
     */
    public void Explode() {
        AsteroidField.GetInstance().RemoveSpaceObject(this);
        for (int i = workers.size() - 1; i >= 0; i--) {
            workers.get(i).Explode();
        }
        for (SpaceObject so : neighbours) {
            so.RemoveNeighbour(this);
        }
        changeEvent.firePropertyChange("exploded", false, true);
    }

    /**
     * Returns if something can hide in the asteroid
     *
     * @return true, if something can hide in it
     */
    public boolean CanHideIn() {
        return layers == 0 && core == null;
    }

    /**
     * Adds worker to the workers list.
     *
     * @param worker worker to be added to the workers list
     */
    public void AddWorker(Worker worker) {
        ArrayList<Worker> old = (ArrayList<Worker>)workers.clone();
        workers.add(worker);
        worker.SetPosition(this);
        changeEvent.firePropertyChange("workers", old, workers);
    }

    /**
     * Removes worker from workers list.
     *
     * @param worker worker to be removed from workers list
     */
    public void RemoveWorker(Worker worker) {
        ArrayList<Worker> old = (ArrayList<Worker>)workers.clone();
        workers.remove(worker);
        changeEvent.firePropertyChange("workers", old, workers);
    }

    /**
     * Sets material to core.
     *
     * @param material the new core of the asteroid.
     */
    public void SetCore(Material material) {
        Material old = core;
        core = material;
        changeEvent.firePropertyChange("core", old, core);
    }

    /**
     * Removes spaceobject from neighbours. Adds a new neighbour if none left.
     *
     * @param spaceObject space object to be removed
     */
    public void RemoveNeighbour(SpaceObject spaceObject) {
        ArrayList<SpaceObject> old = (ArrayList<SpaceObject>) neighbours.clone();
        neighbours.remove(spaceObject);
        if (neighbours.size() == 0) {
            //todo lehet csak butus vagyok, de mí nó ért
            if (spaceObject.GetNeighbours().size() == 0) {
                return;
            }
            ArrayList<SpaceObject> potentialNeighbours = spaceObject.GetNeighbours();
            if (potentialNeighbours.size() > 1) {
                SpaceObject obj = potentialNeighbours.get(Game.RandomNum(potentialNeighbours.size() - 1));
                this.AddNeighbour(obj);
            } else {
                SpaceObject so;
                potentialNeighbours = AsteroidField.GetInstance().GetObjects();
                do {
                    so = potentialNeighbours.get(Game.RandomNum(potentialNeighbours.size() - 1));
                } while (so == this);
                this.AddNeighbour(so);
            }
        }
        changeEvent.firePropertyChange("neighbours", old, neighbours);
    }

    /**
     * Handles, when the solarstorm hits the asteroid
     */
    public void HandleSolarStorm() {
        if (!CanHideIn()) {
            while (workers.size() != 0) {
                workers.get(0).HandleSolarStorm();
            }
        }
    }

    /**
     * @return true, if it is close to the sun
     */
    public boolean IsCloseToSun() {
        return distanceFromSun < 2.5f;
    }

    /**
     * Gets the material inside the core of the asteroid
     *
     * @return The material in the core
     */
    public Material GetCore() {
        return core;
    }

    /**
     * Gets the number of undamaged layers of the crust
     *
     * @return The number of undamaged layers
     */
    public int GetLayers() {
        return layers;
    }

    /**
     * Sets the number of layers of the crust
     *
     * @param layers the number the layers of the crust
     */
    public void SetLayers(int layers) {
        changeEvent.firePropertyChange("layers", this.layers, layers);
        this.layers = layers;
    }

    /**
     * Gets the asteroid's distance from sun
     *
     * @return The distance from the sun
     */
    public float GetDistance() {
        return distanceFromSun;
    }

    /**
     * Sets the asteroid's distance from the sun
     *
     * @param distanceFromSun the distance from the sun
     */
    public void SetDistance(int distanceFromSun) {
        changeEvent.firePropertyChange("distanceFromSun", this.distanceFromSun, distanceFromSun);
        this.distanceFromSun = distanceFromSun;
    }

}
