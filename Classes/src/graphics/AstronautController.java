package graphics;

import game_classes.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
        astronaut.GetChangeEvent().addPropertyChangeListener(this);
        view = new AstronautView(astronaut,this);
        view.DrawAstronaut(astronaut);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        view.DrawAstronaut(astronaut);
        if (evt.getPropertyName().equals("ActiveAstronaut") && evt.getNewValue() == astronaut) {
            view.SetButtonStatus();

        }
        if (evt.getPropertyName().equals("InActiveAstronaut")){
            System.out.println("inaktiv ghecciii");
        }
    }

    public EventHandler<ActionEvent> DrillEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            try {
                astronaut.Drill();
                System.out.println("drill");
                System.out.println(astronaut.toString()+"yup");
                astronaut.GetChangeEvent().firePropertyChange("InActiveAstronaut", null, this);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    public EventHandler<ActionEvent> MineEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            try {
                System.out.println("mine");
                //astronaut.Mine(); //todo
                astronaut.GetChangeEvent().firePropertyChange("InActiveAstronaut", null, this);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    };

    public EventHandler<ActionEvent> PlaceEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            try {
                //astronaut.PlaceMaterial(); //todo
                astronaut.GetChangeEvent().firePropertyChange("InActiveAstronaut", null, this);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    };

    public EventHandler<ActionEvent> WaitEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            System.out.println("wait");
            astronaut.GetChangeEvent().firePropertyChange("InActiveAstronaut", null, this);

           //astronaut.Wait();
        }
    };

    public EventHandler<ActionEvent> MoveEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            System.out.println("movee");
            //astronaut.Move(); //todo

        }
    };

}
