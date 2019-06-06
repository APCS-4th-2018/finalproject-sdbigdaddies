
/**
 * Write a description of class GUI here.
 * creates a basic gui that takes user input and creates a simulation object
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
    //instance variables
    Stage window;
    Scene menu;
    VBox layout;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    /**
     * Start method creates and displays the window menu scene 
     * @param main primary stage that sets up the initial scene
     */
    public void start(Stage primaryStage) throws Exception
    {
        //creates initial scene with tital torsional pendelum lab
        window = primaryStage;
        window.setTitle("Torsional Pendelum Lab");
        
        //creates a horizontal layout that is centered
        HBox selection = new HBox(15);
        selection.setAlignment(Pos.CENTER);
        
        //calls bar method that takes and validates bar input
        Button bar = new Button("Bar");
        bar.setOnAction(e -> barIn());
        
        //calls rod method that takes and validates rod input
        Button rod = new Button("Rod");
        rod.setOnAction(e -> diskrodIn("Rod"));
        
        //calls disk method that takes and validates disk input
        Button disk = new Button("Disk");
        disk.setOnAction(e -> diskrodIn("Disk"));
        
        //calls sphere method that takes and validates sphere input
        Button sphere = new Button("Sphere");
        sphere.setOnAction(e -> sphereIn());
        
        //adds button to layout
        selection.getChildren().addAll(bar, rod, disk, sphere);
        
        //creates window using layout and scene
        menu = new Scene(selection, 700, 700);
        menu.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
        window.setScene(menu);
        window.show();
        
        
    
        
        
    }
    
    /*
     * takes bar input from user and uses the validator object to validate the input
     */
    private void barIn()
    {    
        //local variables
        layout  = new VBox(15);
        layout.setPadding(new Insets(20, 20, 20, 20));
        Validator valid = new Validator();
       
        //creates the horizonatal rows that have input prompt and textfield
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
        row4.getChildren().addAll(tConstant, tConstantInput);
        
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
        
        //go back to main menu
        Button back = new Button("Back");
        back.setOnAction(e -> {window.setScene(menu); window.show();});
        
        //creates layout
        layout.getChildren().addAll(nameLabel, row1, row2, row3, row4, row5, row6, create, back);
        
        //display scene
        Scene barScene = new Scene(layout, 350, 400);
        barScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
        window.setScene(barScene);
        window.show();
        
        //either simulates using input data or reprompts user by displaying error pop up with invalid inpuit
        create.setOnAction(e -> {
           if(!valid.diskrodCheck(thetaInput, massInput, radiusInput, tConstantInput, heightInput))
           {
             //redisplay scene
             Scene drScene = new Scene(layout, 350, 400);
             drScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
             window.setScene(drScene);
             window.show();
          }
          else
            //move on and simulate pendelum
             System.out.print("move on?");});
             
        
    }
    
     /*
     * takes disk or rod input from user and uses the validator object to validate the input
     */
    private void diskrodIn(String title)
    {
        //local variables
        layout = new VBox(15);
        layout.setPadding(new Insets(20, 20, 20, 20));
        Validator valid = new Validator();
        
        //creates the horizonatal rows that have input prompt and textfield
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
        
        //go back to main menu
        Button back = new Button("Back");
        back.setOnAction(e -> {window.setScene(menu); window.show();});
        
        //creates layout
        layout.getChildren().addAll(nameLabel, row1, row2, row3, row4, row5,row6, create, back);
      
            //display the scene
             Scene diskrodScene = new Scene(layout, 350, 400);
             diskrodScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
             window.setScene(diskrodScene);
             window.show();
             
        //either simulates using input data or reprompts user by displaying error pop up with invalid inpuit
        create.setOnAction(e -> {
           if(!valid.diskrodCheck(thetaInput, massInput, radiusInput, tConstantInput, heightInput))
           {
             Scene drScene = new Scene(layout, 350, 400);
             drScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
             window.setScene(drScene);
             window.show();
          }
          else
             System.out.print("move on?");});
       
       
    }
    
      /*
     * takes sphere input from user and uses the validator object to validate the input
     */
    private void sphereIn()
    {
        //local variables
        layout = new VBox(15);
        layout.setPadding(new Insets(20, 20, 20, 20));
        Validator valid = new Validator();
       
        //creates the horizonatal rows that have input prompt and textfield
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
        //go back to main menu
        Button back = new Button("Back");
        back.setOnAction(e -> {window.setScene(menu); window.show();});
        
        //creates layout
        layout.getChildren().addAll(nameLabel, row1, row2, row3, row4, create, back);
        
        //display the scene
        Scene sphereScene = new Scene(layout, 350, 400);
        sphereScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
        window.setScene(sphereScene);
        window.show();
        
        //either simulates using input data or reprompts user by displaying error pop up with invalid inpuit
        create.setOnAction(e -> {
           if(!valid.sphereCheck(thetaInput, massInput, radiusInput, tConstantInput))
           {
             Scene drScene = new Scene(layout, 350, 400);
             drScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
             window.setScene(drScene);
             window.show();
          }
          else
            //move and on and simulate pendelum
            System.out.print("move on?");});
            
        
    }
}