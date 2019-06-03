
/**
 * Write a description of class GUI here.
 *
 * @author (David Glozman)
 * @version (052419)
 */
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class GUI extends Application 
{
    Stage window;
    Scene scene;
    VBox layout;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Torsional Pendelum Lab");
        
        HBox row1 = new HBox(5);
        HBox row2 = new HBox(5);
        HBox row3 = new HBox(5);
        HBox row4 = new HBox(5);
        HBox row5 = new HBox(5);
        
        layout  = new VBox(15);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        //title at the top
        Label nameLabel = new Label("Mr. Liaos Torisonal Pendelum Experience");
       
        //Theta Label
        Label initT = new Label("Initial Theta:");
       
        //Theta Input
        TextField thetaInput = new TextField();
        thetaInput.setPromptText("intial theta value");
        
        //creates row one
        row1.getChildren().addAll(initT, thetaInput);
        
        //Mass Label
        Label mass = new Label("Mass:");
       
        //Mass Input
        TextField massInput = new TextField();
        massInput.setPromptText("mass value");
        
        //creates row 2
        row2.getChildren().addAll(mass, massInput);
        
        //Radius Label
        Label radius = new Label("Radius:");
        
        //Radius Input
        TextField radiusInput = new TextField();
        radiusInput.setPromptText("radius value");
        
        //creates row 3 
        row3.getChildren().addAll(radius, radiusInput);
        
        //Physical Object Label
        Label pObj = new Label("Physical Object Type:");
        
        //Physical Object input
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Bar", "Rod", "Disk", "Sphere");
        
        //creates row 4 
        row4.getChildren().addAll(pObj, choiceBox);
        
        //Torsional Constant 
        Label tConstant = new Label("Torsional Constant:");
        
        //Torsional Constant input
        TextField tConstantInput = new TextField();
        tConstantInput.setPromptText("torsional constant value");
        
        //creates row 5
        row5.getChildren().addAll(tConstant, tConstantInput);
        
        //simulation button
        Button create = new Button("Enter");
        create.setOnAction(e -> {checkInput(massInput, radiusInput, thetaInput, tConstantInput);});
        
        layout.getChildren().addAll(nameLabel, row1, row2, row3, row4, row5, create);
        
        scene = new Scene(layout, 350, 320);
        window.setScene(scene);
        window.show();
    }
    
    private void checkInput(TextField mass, TextField radius, TextField angle, TextField torque)
    {
        boolean check = true;
        
        if(!Validator.isInt(mass))
            layout.getChildren().add(new Label("Error: Mass must be a positive and numerical value"));
            
        if(!Validator.isInt(radius))
            layout.getChildren().add(new Label("Error: Radius must be a positive and numerical value"));
            
        if(!Validator.isInt(angle))
            layout.getChildren().add(new Label("Error: Angle must be a positive and numerical value"));
            
        if(!Validator.isInt(torque))
            layout.getChildren().add(new Label("Error: Torsional constant must be a positive and numerical value"));
            
        Lab run = new Lab(mass.getText(), radius.getText(), angle.getText(), torque.getText());
            
    }
}