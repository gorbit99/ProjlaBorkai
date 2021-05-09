package graphics;

import game_classes.Asteroid;
import game_classes.AsteroidField;
import game_classes.Game;
import game_classes.SpaceObject;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SpaceObjectController implements PropertyChangeListener {
    private SpaceObject spaceObject;
    private SpaceObjectView view;

    //todo ez az osztálydián privát
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    private SpaceObjectController(SpaceObject so, SpaceObjectView sv) {
        spaceObject = so;
        view = sv;
    }

    public static SpaceObjectController createAsteroidController(int id) {
        Asteroid asteroid = new Asteroid();

        ImageView imageView = new ImageView();
        Pane asteroidsGroup = GameController.getInstance().getAsteroidFieldGroup();

        double width = asteroidsGroup.getMaxWidth();
        double height = asteroidsGroup.getMaxHeight();

        double gridWidth = width / AsteroidField.getAsteroidFieldWidth();
        double gridHeight = height / AsteroidField.getAsteroidFieldHeight();

        int groupX = id / AsteroidField.getAsteroidFieldWidth();
        int groupY = id % AsteroidField.getAsteroidFieldWidth();

        double asteroidWidth = width / AsteroidField.getAsteroidFieldWidth() / 2;

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
        switch (Game.getRandomGenerator().nextInt(5)) {
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

        AsteroidView asteroidView = new AsteroidView(imageView, materialController.getView());
        asteroid.SetCore(materialController.getMaterial());

        return new SpaceObjectController(asteroid, asteroidView);
    }
}
