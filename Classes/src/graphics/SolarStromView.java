package graphics;

import game_classes.Material;
import game_classes.SolarStorm;
import javafx.scene.image.Image;

import javax.swing.text.html.ImageView;

public class SolarStromView {
    protected ImageView imageView;

    public void Draw(SolarStorm solarStorm) {

    }

    public SolarStromView(javafx.scene.image.ImageView imageView){
        imageView.setImage(new Image(""));
    }
}
