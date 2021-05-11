package graphics;

import game_classes.SolarStorm;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Controller for the solarstorm.
 */
public class SolarStormController implements PropertyChangeListener {
    private SolarStorm solarStrom;
    private SolarStromView solarStromView;

    /**
     * Event Handler for the property changes of a solarstorm
     * @param evt
     */
    public void propertyChange(PropertyChangeEvent evt) {
        solarStromView.Draw(solarStrom);

    }
}
