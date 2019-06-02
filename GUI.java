
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
import javafx.scene.control.ChoiceBox;
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
        
        //create layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        //title at the top
        Label nameLabel = new Label("Mr. Liaos Torisonal Pendelum Experience");
        GridPane.setConstraints(nameLabel, 0, 5);
        
        //Theta Label
        Label initT = new Label("Initial Theta:");
        GridPane.setConstraints(initT, 1, 2);
        
        //Theta Input
        TextField thetaInput = new TextField();
        thetaInput.setPromptText("intial theta value");
        GridPane.setConstraints(thetaInput, 1, 3);
        
        //Mass Label
        Label mass = new Label("Mass:");
        GridPane.setConstraints(mass, 2, 2);
        
        //Mass Input
        TextField massInput = new TextField();
        thetaInput.setPromptText("mass value");
        GridPane.setConstraints(massInput, 2, 3);
        
        //Radius Label
        Label radius = new Label("Radius:");
        GridPane.setConstraints(radius, 3, 2);
        
        //Radius Input
        TextField radiusInput = new TextField();
        thetaInput.setPromptText("radius value");
        GridPane.setConstraints(massInput, 3, 3);
        
        //Physical Object Label
        Label pObj = new Label("Physical Object Type:");
        GridPane.setConstraints(pObj, 4, 2);
        
        //Physical Object input
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Bar", "Rod", "Disk", "Sphere");
        GridPane.setConstraints(choiceBox, 4, 3);
        
        //Torsional Constant 
        Label tConstant = new Label("Torsional Constant:");
        GridPane.setConstraints(tConstant, 5, 2);
        
        
        //simulation button
        Button create = new Button("Enter");
        GridPane.setConstraints(create, 6, 2);
        
    }
}