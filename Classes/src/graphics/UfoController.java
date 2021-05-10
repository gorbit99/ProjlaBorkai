package graphics;

import game_classes.*;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class UfoController extends WorkerController{
    private Ufo ufo;
    private UfoView view;

    public UfoController() {
        ArrayList<SpaceObject> asteroids = AsteroidField.GetInstance().GetObjects();

        Asteroid newPosition = (Asteroid) asteroids.get(Game.RandomNum(asteroids.size()));
        ufo = new Ufo(newPosition);
        ufo.GetChangeEvent().addPropertyChangeListener(this);

        view = new UfoView();
        view.DrawUfo(ufo);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        view.DrawUfo(ufo);
    }
}
