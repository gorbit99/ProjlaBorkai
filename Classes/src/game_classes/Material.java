package game_classes;

import java.beans.PropertyChangeSupport;

/**
 * This class represents the material. This is the parent class of all materials.
 */
public abstract class Material {
    protected PropertyChangeSupport changeEvent;

    public PropertyChangeSupport GetChangeEvent() {
        return changeEvent;
    }

    /**
     * This is the constructor of the material.
     */
    public Material() {
    }

    /**
     * This method handles, when the material gets closes to the sun.
     *
     * @param asteroid The asteroid is what contains this material.
     */
    public void HandleCloseToSun(Asteroid asteroid) {
    }
}
