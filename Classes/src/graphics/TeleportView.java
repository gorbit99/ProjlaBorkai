package graphics;

import game_classes.AsteroidField;
import game_classes.Game;
import game_classes.SpaceObject;

import game_classes.Teleporter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class TeleportView extends SpaceObjectView {

    private Line neighbourLine;

    public TeleportView(Teleporter teleporter) {
        imageView = new ImageView(new Image("/Pictures/portal.png"));
        GameController.getInstance().getAsteroidFieldGroup().getChildren().add(imageView);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);

        SpaceObjectController parent = SpaceObjectController.controllerFromSpaceObject(teleporter.GetParent());

        double angle = 2 * Math.PI * Game.getRandomGenerator().nextDouble();
        ImageView asteroidView = parent.getView().imageView;
        double len = Math.sqrt(asteroidView.getFitWidth() * asteroidView.getFitWidth()
                + asteroidView.getFitHeight() * asteroidView.getFitHeight()) / 2;

        double x = Math.cos(angle) * len * asteroidView.getLayoutX() + asteroidView.getFitWidth() / 2;
        double y = Math.sin(angle) * len * asteroidView.getLayoutY() + asteroidView.getFitHeight() / 2;

        imageView.setLayoutX(x - imageView.getFitWidth() / 2);
        imageView.setLayoutY(y - imageView.getFitHeight() / 2);
    }

    @Override
    public void Draw(SpaceObject spaceObject) {
        Teleporter teleporter = (Teleporter) spaceObject;
        if (neighbourLine != null) {
            GameController.getInstance().getAsteroidFieldGroup().getChildren().remove(neighbourLine);
        }

        if (teleporter.GetPair() == null) {
            return;
        }

        int thisId = AsteroidField.GetInstance().GetObjects().indexOf(teleporter);
        int otherId = AsteroidField.GetInstance().GetObjects().indexOf(teleporter.GetPair());

        if (thisId > otherId) {
            return;
        }

        SpaceObjectController pairController =
                SpaceObjectController.controllerFromSpaceObject(teleporter.GetPair());
        ImageView pairIV = pairController.getView().imageView;

        double nX = pairIV.getLayoutX() + pairIV.getFitWidth() / 2;
        double nY = pairIV.getLayoutY() + pairIV.getFitHeight() / 2;
        double X = imageView.getLayoutX() + imageView.getFitWidth() / 2;
        double Y = imageView.getLayoutY() + imageView.getFitHeight() / 2;

        double bufferZone = Math.sqrt(imageView.getFitWidth() * imageView.getFitWidth()
                + imageView.getFitHeight() * imageView.getFitHeight()) / 2;

        double otherVecX = X - nX;
        double otherVecY = Y - nY;
        double len = Math.sqrt(otherVecX * otherVecX + otherVecY * otherVecY);
        otherVecX /= len;
        otherVecY /= len;

        nX += otherVecX * bufferZone;
        nY += otherVecY * bufferZone;
        X -= otherVecX * bufferZone;
        Y -= otherVecY * bufferZone;

        Line line = new Line(X, Y, nX, nY);
        line.getStrokeDashArray().addAll(10d, 10d);

        GameController.getInstance().getAsteroidFieldGroup().getChildren().add(line);

        neighbourLine = line;
    }
}
