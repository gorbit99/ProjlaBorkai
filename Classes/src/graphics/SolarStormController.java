package graphics;

import game_classes.SolarStorm;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SolarStormController implements PropertyChangeListener {
    private SolarStorm solarStrom;
    private SolarStromView solarStromView;

    public void propertyChange(PropertyChangeEvent evt) {
        solarStromView.Draw(solarStrom);

    }
}
