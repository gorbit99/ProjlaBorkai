package graphics;

import game_classes.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;

public class SpaceObjectController implements PropertyChangeListener {
    private final SpaceObject spaceObject;
    private final SpaceObjectView view;

    private static final ArrayList<SpaceObjectController> spaceObjectControllers = new ArrayList<>();

    private static final ArrayList<Integer> materialsRequired;

    static {
        materialsRequired = new ArrayList<>();
        for (int i = 0; i < AsteroidField.getAsteroidFieldWidth() * AsteroidField.getAsteroidFieldHeight(); i++) {
            materialsRequired.add(i % 5);
        }
        Collections.shuffle(materialsRequired);
    }

    //todo ez az osztálydián privát
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    private SpaceObjectController(SpaceObject so, SpaceObjectView sv) {
        spaceObject = so;
        view = sv;
        spaceObjectControllers.add(this);
    }

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

    public static SpaceObjectController createTeleporterController(Asteroid asteroid) {
//        Teleporter teleporter = new Teleporter()
    }

    public SpaceObject getSpaceObject() {
        return spaceObject;
    }

    public SpaceObjectView getView() {
        return view;
    }

    public static SpaceObjectController controllerFromSpaceObject(SpaceObject spaceObject) {
        return spaceObjectControllers.stream().filter(x -> x.spaceObject == spaceObject).findFirst().get();
    }
}
