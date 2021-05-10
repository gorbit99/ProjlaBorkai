package graphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainView extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * start point of the game
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root, Color.ORANGE);
        String css = this.getClass().getResource("menuStyle.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Asteroid the game by ProjlaBorka(i)®");
        stage.getIcons().add(new Image("/Pictures/logo.png"));
        stage.show();
    }
}
