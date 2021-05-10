package game_classes;

import java.beans.PropertyChangeSupport;

/**
 * This class represents the SolarStorms in the game.
 */
public class SolarStorm {

    protected PropertyChangeSupport changeEvent = new PropertyChangeSupport(this);

    public PropertyChangeSupport GetChangeEvent() {
        return changeEvent;
    }

    /**
     * parameter that stores the number of rounds
     * left until the next solar storm
     */
    private int timeTillHit;

    /**
     * Constructor of the class.
     */
    public SolarStorm() {
        timeTillHit = Game.RandomNum(10) + 10;
    }

    /**
     * Decreases the object's inner counter, resets it if necessary, returns whether a solarstorm should happen.
     *
     * @return True if a solarstorm is happening, false otherwise.
     */
    public boolean Tick() {
        if (timeTillHit == 0) {
            AsteroidField.GetInstance().HandleSolarStorm();
            timeTillHit = Game.RandomNum(10) + 10;
            return true;
        }
        int old = timeTillHit;
        timeTillHit--;
        changeEvent.firePropertyChange("timeTillHit", old, timeTillHit);

        return false;
    }

    /**
     * Gets the number of turns remaining until the solarstorm hits
     *
     * @return the number of turns remaining
     */
    public int GetTimeTillHit() {
        return timeTillHit;
    }

    /**
     * Sets the number of turns remaining until the solarstorm hits
     *
     * @param timeTillHit the number of turns remaining
     */
    public void SetTimeTillHit(int timeTillHit) {
        int old = this.timeTillHit;
        this.timeTillHit = timeTillHit;
        changeEvent.firePropertyChange("timeTillHit", old, timeTillHit);
    }
}
