package graphics;

import game_classes.Material;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IceView extends MaterialView{
    //todo
    @Override
    public void Draw(Material material) {

    }

    public IceView(ImageView iv){
        super(iv);
        image.setImage(new Image("/Pictures/iron.png"));
    }
}
