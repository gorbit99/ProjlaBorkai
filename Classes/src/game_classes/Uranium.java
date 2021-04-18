package game_classes;

/**
 * This class represents the uranium. It extends from material.
 */
public class Uranium extends Material {

    /**
     * exposureCount represents how many times has the uranium been exposed
     * to the sun
     */
    private int exposureCount;

    /**
     * This is the constructor of the ice.
     */
    public Uranium() {
    }

    /**
     * This method makes the asteroid explode.
     * explodes when the material has been exposed to sun 3 times
     * @param asteroid The asteroid is what contains this material.
     */
    @Override
    public void HandleCloseToSun(Asteroid asteroid) {
        exposureCount++;
        if (exposureCount == 3)
            asteroid.Explode();
    }

    /**
     * @return The class name.
     */
    public String toString() {
        return "Uranium";
    }

    public int GetExposure() {
        return exposureCount;
    }

    public void SetExposure(int exposureCount) {
        this.exposureCount = exposureCount;
    }
}
