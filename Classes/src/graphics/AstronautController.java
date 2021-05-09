package graphics;

import game_classes.Asteroid;
import game_classes.AsteroidField;
import game_classes.Astronaut;
import game_classes.Game;

import java.beans.PropertyChangeEvent;

public class AstronautController extends WorkerController {
    private Astronaut astronaut;
    private AstronautView view;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public static void CreateAstronautController() {
        Astronaut as = new Astronaut((Asteroid) AsteroidField.GetInstance().GetObjects().get(Game.GetInstance().RandomNum(AsteroidField.GetInstance().GetObjects().size())));


    }
}
