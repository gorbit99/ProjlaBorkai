package graphics;

import game_classes.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Controller for the space objects
 */
public class SpaceObjectController implements PropertyChangeListener {
    private SpaceObject spaceObject;
    private SpaceObjectView view;

    /**
     * collection of the space objects in the game
     */
    private static ArrayList<SpaceObjectController> spaceObjectControllers = new ArrayList<>();

    /**
     * Collection of indexes of the necessary materials, useful, when setting up the game
     */
    private static ArrayList<Integer> materialsRequired;

    static {
        materialsRequired = new ArrayList<>();
        for (int i = 0; i < AsteroidField.getAsteroidFieldWidth() * AsteroidField.getAsteroidFieldHeight(); i++) {
            materialsRequired.add(i % 5);
        }
        Collections.shuffle(materialsRequired);
    }

    /**
     * Event handler for the property changes of the space object this object controls
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("core")){
            if (evt.getNewValue() == null){
                //NoMaterialView nomaterial = new NoMaterialView(new Coal());
                //((AsteroidView)view).SetView(nomaterial);
            }
        }
        view.Draw(spaceObject);
    }

    /**
     * Constructor of the class
     * @param so the space object
     * @param sv the view for the space object
     */
    private SpaceObjectController(SpaceObject so, SpaceObjectView sv) {
        spaceObject = so;
        view = sv;
        spaceObjectControllers.add(this);
        spaceObject.GetChangeEvent().addPropertyChangeListener(this);
    }

    /**
     * Creates an asteroid controller
     * @param id identifier, defines the placement of the asteroid
     * @return the asteroid controller
     */
    public static SpaceObjectController createAsteroidController(int id) {
        Asteroid asteroid = new Asteroid();

        ImageView imageView = new ImageView();
        Pane asteroidsGroup = GameController.getInstance().getAsteroidFieldGroup();

        double width = asteroidsGroup.getMaxWidth();
        double height = asteroidsGroup.getMaxHeight();

        double gridWidth = width / AsteroidField.getAsteroidFieldWidth();
        double gridHeight = height / AsteroidField.getAsteroidFieldHeight();

        int groupX = id % AsteroidField.getAsteroidFieldWidth();
        int groupY = id / AsteroidField.getAsteroidFieldWidth();

        double asteroidWidth = width / AsteroidField.getAsteroidFieldWidth() / 3;

        double x = gridWidth * groupX + Game.getRandomGenerator().nextDouble() * (gridWidth - asteroidWidth);
        double y = gridHeight * groupY + Game.getRandomGenerator().nextDouble() * (gridHeight - asteroidWidth);

        imageView.setFitWidth(asteroidWidth);
        imageView.setFitHeight(asteroidWidth);

        asteroidsGroup.getChildren().add(imageView);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);

        ImageView materialIV = new ImageView();
        materialIV.setFitWidth(imageView.getFitWidth() / 2);
        materialIV.setFitHeight(imageView.getFitHeight() / 2);
        materialIV.setLayoutX(imageView.getLayoutX() + imageView.getFitWidth() / 2 - materialIV.getFitWidth() / 2);
        materialIV.setLayoutY(imageView.getLayoutY() + imageView.getFitHeight() / 2 - materialIV.getFitHeight() / 2);
        asteroidsGroup.getChildren().add(materialIV);

        MaterialController materialController;
        switch (materialsRequired.get(materialsRequired.size() - 1)) {
            case 0:
                materialController = MaterialController.CreateCoal(materialIV);
                break;
            case 1:
                materialController = MaterialController.CreateIce(materialIV);
                break;
            case 2:
                materialController = MaterialController.CreateIron(materialIV);
                break;
            case 3:
                materialController = MaterialController.CreateUranium(materialIV);
                break;
            default:
                materialController = MaterialController.CreateNoMaterial(materialIV);
                break;
        }

        materialsRequired.remove(materialsRequired.size() - 1);

        AsteroidView asteroidView = new AsteroidView(imageView, materialController.getView(), asteroid);
        asteroid.SetCore(materialController.getMaterial());

        return new SpaceObjectController(asteroid, asteroidView);
    }

    /**
     * Creates a teleporter controller
     * @param teleporter the teleporter object this controller will control
     * @return the teleporter controller
     */
    public static SpaceObjectController createTeleporterController(Teleporter teleporter) {
        //Teleporter teleporter = new Teleporter()
        return null;
        //return new SpaceObjectController(teleporter, new TeleportView(teleporter));
    }

    /**
     * Gets the space object this object controls
     * @return space object controlled by this controller
     */
    public SpaceObject getSpaceObject() {
        return spaceObject;
    }

    /**
     * Gets the view this controller handles
     * @return  the view
     */
    public SpaceObjectView getView() {
        return view;
    }

    /**
     * Gets the controller of a space object
     * @param spaceObject the spaceobject whose controller will be returnd
     * @return the controller of the spaceobject specified in the parameters.
     */
    public static SpaceObjectController controllerFromSpaceObject(SpaceObject spaceObject) {
        return spaceObjectControllers.stream().filter(x -> x.spaceObject == spaceObject).findFirst().get();
    }
}
