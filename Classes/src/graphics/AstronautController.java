package graphics;

import game_classes.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
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

    /**
     * Constructor of the class
     */
    public AstronautController() {
        ArrayList<SpaceObject> asteroids = AsteroidField.GetInstance().GetObjects();

        Asteroid newPosition = (Asteroid) asteroids.get(Game.RandomNum(asteroids.size()));
        astronaut = new Astronaut(newPosition);
        astronaut.GetChangeEvent().addPropertyChangeListener(this);
        view = new AstronautView(astronaut, this);
        view.DrawAstronaut(astronaut);
    }

    /**
     * Event Handler for the propertychangeevent
     * @param evt the caught event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        view.SetActivePic();
        if (evt.getPropertyName().equals("ActiveAstronaut") && evt.getNewValue() == astronaut) {
            view.SetButtonStatus();
            view.DrawAstronaut(astronaut);


        }
        if (evt.getPropertyName().equals("InActiveAstronaut")) {
            System.out.println("inaktiv");
        }

    }

    /**
     * Event Handler for the drill action
     */
    public EventHandler<ActionEvent> DrillEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            try {
                astronaut.Drill();
                System.out.println("drill");
                System.out.println(astronaut.toString());
                endTurn();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    /**
     * Event Handler for the mine action
     */
    public EventHandler<ActionEvent> MineEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            try {
                System.out.println("mine");
                astronaut.Mine(); //todo
                endTurn();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    /**
     * Event Handler for the place action
     */
    public EventHandler<ActionEvent> PlaceEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            try {
                System.out.println("sün");
                astronaut.PlaceMaterial(); //todo
                endTurn();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    /**
     * Event Handler for the wait action
     */
    public EventHandler<ActionEvent> WaitEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            astronaut.Wait();
            endTurn();
        }
    };

    /**
     * Event Handler for the move action
     */
    public EventHandler<ActionEvent> MoveEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            view.Unsubscribe();
            view.SubscribeToSpaceObjects();
        }
    };

    /**
     * Event Handler for the create robot action
     */
    public EventHandler<ActionEvent> CreateRobotEventHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent e) {
            try {
                astronaut.CreateRobot();
                endTurn();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    };

    /**
     * A wrapper function for the TravelTo method in astronaut. Unsubscribes from the events of the spaceobjects.
     * @param so The space object the astronaut will travel to.
     */
    public void TravelToWrapper(SpaceObject so) {
        astronaut.TravelTo(so);
        view.UnSubscribeFromSpaceObjects();
        endTurn();
    }

    /**
     * Little helper function for frequently repeated calls.
     */
    private void endTurn() {
        view.Unsubscribe();
        Game.GetInstance().nextTurn();
        view.SetPassivePic();
        //GameController.getInstance().getInventoryBox().getChildren().clear();
    }
}
