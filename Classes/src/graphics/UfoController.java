package graphics;

import game_classes.*;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

/**
 * Controller for the ufo
 */
public class UfoController extends WorkerController{
    /**
     * Ufo this class controls
     * view this class controls
     */
    private Ufo ufo;
    private UfoView view;

    /**
     * Constructor of the class
     */
    public UfoController() {
        ArrayList<SpaceObject> asteroids = AsteroidField.GetInstance().GetObjects();

        Asteroid newPosition = (Asteroid) asteroids.get(Game.RandomNum(asteroids.size()));
        ufo = new Ufo(newPosition);
        ufo.GetChangeEvent().addPropertyChangeListener(this);

        view = new UfoView();
        view.DrawUfo(ufo);
    }

    /**
     * Event handler for the property of the changes of the ufo
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        view.DrawUfo(ufo);
    }
}
