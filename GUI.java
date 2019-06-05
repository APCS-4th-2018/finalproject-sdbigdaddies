
/**
 * Write a description of class GUI here.
 *
 * @author (David Glozman)
 * @version (052419)
 */
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class GUI extends Application 
{
    Stage window;
    Scene menu;
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
        
        HBox selection = new HBox(15);
        selection.setAlignment(Pos.CENTER);
        
        Button bar = new Button("Bar");
        bar.setOnAction(e -> barIn());
        
        Button rod = new Button("Rod");
        rod.setOnAction(e -> diskrodIn("Rod"));
        
        Button disk = new Button("Disk");
        disk.setOnAction(e -> diskrodIn("Disk"));
        
        Button sphere = new Button("Sphere");
        sphere.setOnAction(e -> sphereIn());
        
        selection.getChildren().addAll(bar, rod, disk, sphere);
        
        
        
        
        menu = new Scene(selection, 700, 700);
        menu.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
        window.setScene(menu);
        window.show();
        
        
    
        
        
    }
    
    private void barIn()
    {    
        layout  = new VBox(15);
        layout.setPadding(new Insets(20, 20, 20, 20));
       
        HBox row1 = new HBox(5);
        HBox row2 = new HBox(5);
        HBox row3 = new HBox(5);
        HBox row4 = new HBox(5);
        HBox row5 = new HBox(5);
        HBox row6 = new HBox(5);
        
        //title at the top
        Label nameLabel = new Label("Bar");
       
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
        
        //Torsional Constant 
        Label tConstant = new Label("Torsional Constant:");
        
        //Torsional Constant input
        TextField tConstantInput = new TextField();
        tConstantInput.setPromptText("torsional constant value");
        
        //creates row 4
        row5.getChildren().addAll(tConstant, tConstantInput);
        
        //Height constant input
        Label height = new Label("Height:");
         
        //Height input
        TextField heightInput = new TextField();
        heightInput.setPromptText("height value");
        
        //creates row 5
        row5.getChildren().addAll(height, heightInput);
        
        //Width constant input
        Label width = new Label("Width:");
         
        //Width input
        TextField widthInput = new TextField();
        widthInput.setPromptText("width value");
        
        //creates row 6
        row6.getChildren().addAll(width, widthInput);
        
        //simulation button
        Button create = new Button("Enter");
        
        Button back = new Button("Back");
        
        layout.getChildren().addAll(nameLabel, row1, row2, row3, row4, row5, row6, create, back);
        
        Scene barScene = new Scene(layout, 350, 400);
        barScene.getStyleSheets().add(getClass().getResourse("FXStyling.css").toExternalForm());
        window.setScene(barScene);
        window.show();
    }
    
    private void diskrodIn(String title)
    {
        layout = new VBox(15);
        layout.setPadding(new Insets(20, 20, 20, 20));
       
        HBox row1 = new HBox(5);
        HBox row2 = new HBox(5);
        HBox row3 = new HBox(5);
        HBox row4 = new HBox(5);
        HBox row5 = new HBox(5);
        HBox row6 = new HBox(5);
        
        //title at the top
        Label nameLabel = new Label(title);
       
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
        
        //Torsional Constant 
        Label tConstant = new Label("Torsional Constant:");
        
        //Torsional Constant input
        TextField tConstantInput = new TextField();
        tConstantInput.setPromptText("torsional constant value");
        
        //creates row 4
        row5.getChildren().addAll(tConstant, tConstantInput);
        
        //Height constant input
        Label height = new Label("Height:");
         
        //Height input
        TextField heightInput = new TextField();
        heightInput.setPromptText("height value");
        
        //creates row 5
        row6.getChildren().addAll(height, heightInput);
        
        //simulation button
        Button create = new Button("Enter");
        layout.getChildren().addAll(nameLabel, row1, row2, row3, row4, row5,row6, create);
        
       do
       {
             Scene diskrodScene = new Scene(layout, 350, 400);
             diskrodScene.getStyleSheets().add(getClass().getResourse("FXStyling.css").toExternalForm());
             window.setScene(diskrodScene);
             window.show();
       }
       while();
        
        
        
        
        
       
    }
    
    private void sphereIn()
    {
        layout = new VBox(15);
        layout.setPadding(new Insets(20, 20, 20, 20));
       
        HBox row1 = new HBox(5);
        HBox row2 = new HBox(5);
        HBox row3 = new HBox(5);
        HBox row4 = new HBox(5);
        
        //title at the top
        Label nameLabel = new Label("Sphere");
       
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
        
        //Torsional Constant 
        Label tConstant = new Label("Torsional Constant:");
        
        //Torsional Constant input
        TextField tConstantInput = new TextField();
        tConstantInput.setPromptText("torsional constant value");
        
        //creates row 4
        row4.getChildren().addAll(tConstant, tConstantInput);
        
        //simulation button
        Button create = new Button("Enter");
        
        
        layout.getChildren().addAll(nameLabel, row1, row2, row3, row4, create);
        
        Scene sphereScene = new Scene(layout, 350, 400);
        sphereScene.getStyleSheets().add(getClass().getResourse("FXStyling.css").toExternalForm());
        window.setScene(sphereScene);
        window.show();
    }
}