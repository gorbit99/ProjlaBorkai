package graphics;

import game_classes.Asteroid;
import game_classes.AsteroidField;
import game_classes.SpaceObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

import java.awt.*;
import java.util.ArrayList;

public class AsteroidView extends SpaceObjectView {

    private final static int maxEntityOnAsteroid = 5;

    private MaterialView coreView;
    private ArrayList<Line> neighbourLines = new ArrayList<>();

    /**
     * constructor of asteroid view
     *
     * @param imageView image view of the view
     * @param coreView  view of the asteroid's core
     */
    public AsteroidView(ImageView imageView, MaterialView coreView, SpaceObject spaceObject) {
        this.imageView = imageView;
        imageView.setImage(new Image("/Pictures/Asteroida.png"));
        this.coreView = coreView;
        coreView.ShowView(true);
    }


    /**
     * draw option
     *
     * @param spaceObject
     */
    @Override
    public void Draw(SpaceObject spaceObject) {
        if (((Asteroid) spaceObject).GetLayers() == 0) {
            coreView.ShowView(true);
        }

        drawNeighbourLines(spaceObject);
    }

    private void drawNeighbourLines(SpaceObject spaceObject) {
        for (Line line : neighbourLines) {
            GameController.getInstance().getAsteroidFieldGroup().getChildren().remove(line);
        }

        neighbourLines.clear();

        for (SpaceObject neighbour : spaceObject.GetNeighbours()) {
            if (!(neighbour instanceof Asteroid)) {
                continue;
            }
            Asteroid asteroidNeighbour = (Asteroid) neighbour;

            int thisId = AsteroidField.GetInstance().GetObjects().indexOf(spaceObject);
            int otherId = AsteroidField.GetInstance().GetObjects().indexOf(neighbour);

            if (thisId > otherId) {
                continue;
            }

            SpaceObjectController neighbourController =
                    SpaceObjectController.controllerFromSpaceObject(asteroidNeighbour);
            ImageView neighbourIV = neighbourController.getView().imageView;

            double nX = neighbourIV.getLayoutX() + neighbourIV.getFitWidth() / 2;
            double nY = neighbourIV.getLayoutY() + neighbourIV.getFitHeight() / 2;
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

            neighbourLines.add(line);
        }
    }

    public Point getEntityPosition(int id) {
        double angle = 2 * Math.PI / maxEntityOnAsteroid * id;

        double len = Math.sqrt(imageView.getFitWidth() * imageView.getFitWidth()
                + imageView.getFitHeight() * imageView.getFitHeight()) / 3;

        return new Point((int) (Math.cos(angle) * len + imageView.getLayoutX()),
                (int) (Math.sin(angle) * len + imageView.getLayoutY()));
    }

    public static int getNextEntityId(SpaceObject spaceObject) {
        return spaceObject.GetWorkers().size();
    }

    public void SetView(MaterialView CoreView){
        this.coreView = coreView;
        coreView.ShowView(true);
    }
}
