package game_classes;


/**
 * represents a UFO
 */
public class Ufo extends Worker {



    @Override
    public void Explode() {
        Die();
    }

    /**
     * controls the UFO's movements
     */
    @Override
    public void Step() {

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

    }

    @Override
    public Material[] GetStoredMaterials() {
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
