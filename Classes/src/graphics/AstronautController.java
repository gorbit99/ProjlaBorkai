package graphics;

import game_classes.*;

import java.beans.PropertyChangeEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AstronautController extends WorkerController {
    /**
     * the astronaut which belongs to the controller
     * the image of the astronaut
     */
    private Astronaut astronaut;
    private AstronautView view;

    public AstronautController() {
        ArrayList<SpaceObject> asteroids = AsteroidField.GetInstance().GetObjects();

        Asteroid newPosition = (Asteroid) asteroids.get(Game.RandomNum(asteroids.size()));
        astronaut = new Astronaut(newPosition);

        view = new AstronautView(astronaut);
        view.DrawAstronaut(astronaut);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        view.DrawAstronaut(astronaut);
    }
}
