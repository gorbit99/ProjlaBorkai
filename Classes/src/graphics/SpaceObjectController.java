package graphics;

import game_classes.Asteroid;
import game_classes.AsteroidField;
import game_classes.Game;
import game_classes.SpaceObject;
import javafx.scene.Group;
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

        double width = asteroidsGroup.getBoundsInParent().getWidth();
        double height = asteroidsGroup.getBoundsInParent().getHeight();

        double gridWidth = width / AsteroidField.getAsteroidFieldWidth();
        double gridHeight = height / AsteroidField.getAsteroidFieldHeight();

        int groupX = id % AsteroidField.getAsteroidFieldWidth();
        int groupY = id / AsteroidField.getAsteroidFieldWidth();

        double x = gridWidth * groupX + Game.getRandomGenerator().nextDouble() * gridWidth;
        double y = gridHeight * groupY + Game.getRandomGenerator().nextDouble() * gridHeight;

        imageView.setFitWidth(width / AsteroidField.getAsteroidFieldWidth() / 3);
        imageView.setFitHeight(width / AsteroidField.getAsteroidFieldWidth() / 3);

        asteroidsGroup.getChildren().add(imageView);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);

        AsteroidView asteroidView = new AsteroidView(imageView);

        return new SpaceObjectController(asteroid, asteroidView);
    }
}
