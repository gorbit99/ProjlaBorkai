package graphics;

import game_classes.Material;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UraniumView extends MaterialView{
    //todo
    @Override
    public void Draw(Material material) {

    }

    public UraniumView(ImageView iv){
        super(iv);
        image.setImage(new Image("/Pictures/iron.png"));
    }
}
