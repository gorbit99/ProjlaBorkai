package graphics;

import game_classes.SolarStorm;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//todo ez így nincs
//valahogy le kell kezeljük amikor robbanunk meg amikor eltűnik egy aszteroida
public class SolarStormController implements PropertyChangeListener {
    private SolarStorm solarStrom;
    private SolarStromView solarStromView;

    public void propertyChange(PropertyChangeEvent evt) {
        solarStromView.Draw(solarStrom);

    }
}
