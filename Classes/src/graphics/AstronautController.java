package graphics;

import game_classes.AsteroidField;
import game_classes.Astronaut;

import java.beans.PropertyChangeEvent;

public class AstronautController extends WorkerController {
    private Astronaut astronaut;
    private AstronautView view;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public static void CreateAstronautController() {
        //Astronaut astronaut = new Astronaut(AsteroidField.GetInstance().GetObjects().get());
    }
}
