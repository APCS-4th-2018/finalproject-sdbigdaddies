
/**
 * Write a description of class FX here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application 
{
    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        window = primaryStage;
        window.setTitle("Mr. Liao's ultra-fun webquet for torsional pendelums!!");
        

    }
}

