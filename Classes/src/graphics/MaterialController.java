package graphics;

import game_classes.*;
import javafx.scene.image.ImageView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MaterialController implements PropertyChangeListener {
    private MaterialView view;
    private Material material;
    //TODO ez az osztálydiagrammon privát
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        view.Draw(material);
    }

    private MaterialController(Material m, MaterialView mv){
        material = m;
        view = mv;
    }

    public static MaterialController CreateIron(ImageView iv){

        MaterialView mv = new IronView(iv);
        Iron iron = new Iron();
        return new MaterialController(iron, mv);
    }
    public static MaterialController CreateCoal(ImageView iv){
        MaterialView mv = new CoalView(iv);
        Coal coal = new Coal();
        return new MaterialController(coal, mv);
    }
    public static MaterialController CreateUranium(ImageView iv){
        MaterialView mv = new UraniumView(iv);
        Uranium uranium = new Uranium();
        return new MaterialController(uranium, mv);
    }
    public static MaterialController CreateIce(ImageView iv){
        MaterialView mv = new IceView(iv);
        Ice ice = new Ice();
        return new MaterialController(ice, mv);
    }
}
