package graphics;

import game_classes.Astronaut;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AstronautView {
    private ImageView imageView;

    public AstronautView(){
        imageView.setImage(new Image("/Pictures/spaceship.png"));
    }

    public void DrawAstronaut(Astronaut astronaut){

    }
}
