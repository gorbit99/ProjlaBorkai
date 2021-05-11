package game_classes;

/**
 * This class represents the ice. It extends from material.
 */
public class Ice extends Material {
    /**
     * This is the constructor of the ice.
     */
    public Ice() {
    }

    /**
     * This vaporise the ice, when the asteroid is close to the sun.
     *
     * @param asteroid The asteroid is what contains this material.
     */
    public void HandleCloseToSun(Asteroid asteroid) {
        if (asteroid.IsCloseToSun()) {
            asteroid.SetCore(null);
            changeEvent.firePropertyChange("exist", true, false);
        }
    }

    /**
     * This method returns the name of the class for testing purposes.
     *
     * @return The class name.
     */
    public String toString() {
        return "Ice";
    }
}
