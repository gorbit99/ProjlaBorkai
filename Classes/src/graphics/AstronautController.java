package graphics;

import game_classes.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

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
        if (evt.getPropertyName().equals("ActiveAstronaut") && evt.getNewValue() == astronaut) {
            view.SetButtonStatus();

        }
    }

    EventHandler<MouseEvent> DrillEventHandler = new EventHandler<>() {
        @Override
        public void handle(MouseEvent e) {
            try {
                astronaut.Drill();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    EventHandler<MouseEvent> MineEventHandler = new EventHandler<>() {
        @Override
        public void handle(MouseEvent e) {
            try {
                astronaut.Mine(); //todo
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    };

    EventHandler<MouseEvent> PlaceEventHandler = new EventHandler<>() {
        @Override
        public void handle(MouseEvent e) {
            try {
                astronaut.PlaceMaterial(); //todo
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    };

    EventHandler<MouseEvent> WaitEventHandler = new EventHandler<>() {
        @Override
        public void handle(MouseEvent e) {

            astronaut.Wait();

        }
    };

    EventHandler<MouseEvent> MoveEventHandler = new EventHandler<>() {
        @Override
        public void handle(MouseEvent e) {

            astronaut.Move(); //todo

        }
    };


}
