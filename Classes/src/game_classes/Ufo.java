package game_classes;


import java.util.ArrayList;

/**
 * represents a UFO
 */
public class Ufo extends Worker {


    /**
     * Constructor of the class, every worker has a position.
     * @param position
     */
    public Ufo(Asteroid position) {
        super(position);
    }

    @Override
    public void Explode() {
        Die();
    }

    /**
     * controls the UFO's movements
     */
    @Override
    public void Step() {
        if (this.position.GetCore()!=null)
            this.Steal();
        else
            this.Move();
    }

    /**
     * does not do anything since the UFO cannot drill
     */
    @Override
    public void Drill() {
    }

    /**
     * moves UFO to a random neighbour asteroid
     */
    @Override
    public void Move() {
        SpaceObject pos = this.position.neighbours.get(Game.RandomNum(this.position.neighbours.size()));
        TravelTo(pos);
    }

    /**
     * Doesn't do anything
     * @return
     */
    @Override
    public ArrayList<Material> GetStoredMaterials() {
        return null;
    }

    /**
     * steals the material from an asteroid
     */
    public void Steal() {
        if (this.position.GetCore() != null)
            this.position.SetCore(null);
    }


}
