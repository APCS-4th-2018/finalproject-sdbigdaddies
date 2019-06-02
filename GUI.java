
/**
 * Write a description of class GUI here.
 *
 * @author (David Glozman)
 * @version (052419)
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class GUI extends Application 
{
    Stage window;
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Torsional Pendelum Lab");
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        Label nameLabel = new Label("Mr. Liaos Torisonal Pendelum Experience");
        GridPane.setConstraints(nameLabel, 0, 5);
        
        Label initT = new Label("Initial Theta:");
        GridPane.setConstraints(initT, 1, 2);
        
        //intiial theta Input
        TextField thetaInput = new TextField();
        thetaInput.setPromptText("Enter Intial Theta:");
        GridPane.setConstraints(thetaInput, 1, 3);
        
    }
}