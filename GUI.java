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
    private Stage window;
    private Scene menu;
    private VBox layout;
    
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
        
        //vertical box
        VBox mainMenu = new VBox(15);
        mainMenu.setId("mainMenu");
        
        //creates a horizontal layout that is centered
        HBox selection = new HBox(15);
        selection.setId("selection");
        selection.setAlignment(Pos.CENTER);
        
        //calls bar method that takes and validates bar input
        Button bar = new Button("Bar");
        bar.setOnAction(e -> barIn());
        bar.setId("bar");
        
        //calls rod method that takes and validates rod input
        Button rod = new Button("Rod");
        rod.setOnAction(e -> diskrodIn("Rod"));
        bar.setId("rod");
        
        //calls disk method that takes and validates disk input
        Button disk = new Button("Disk");
        disk.setOnAction(e -> diskrodIn("Disk"));
        disk.setId("disk");
        
        //calls sphere method that takes and validates sphere input
        Button sphere = new Button("Sphere");
        sphere.setOnAction(e -> sphereIn());
        sphere.setId("sphere");
        
        //adds button to layout
        selection.getChildren().addAll(bar, rod, disk, sphere);
        
        Label top = new Label("Mr. Liaos Torsional Pendelum Quest!");
        top.setId("top");
        
        HBox topRow = new HBox(15);
        topRow.getChildren().add(top);
        topRow.setId("topRow");
        topRow.setAlignment(Pos.CENTER);
        
        //align center
        mainMenu.getChildren().addAll(topRow, selection);
        mainMenu.setAlignment(Pos.CENTER);
        
        //creates window using layout and scene
        menu = new Scene(mainMenu, 650, 500);
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
        HBox row7 = new HBox(5);
        
        //title at the top
        Label nameLabel = new Label("Bar");
        nameLabel.setId("nameLabel");
       
        //Theta Label
        Label initT = new Label("Initial Theta:");
        initT.setId("initT");
       
        //Theta Input
        TextField thetaInput = new TextField();
        thetaInput.setPromptText("intial theta value");
        
        
        //creates row one
        row1.getChildren().addAll(initT, thetaInput);
        
        //Mass Label
        Label mass = new Label("Mass:");
        mass.setId("mass");
       
        //Mass Input
        TextField massInput = new TextField();
        massInput.setPromptText("mass value");
        massInput.setId("massInput");
        
        //creates row 2
        row2.getChildren().addAll(mass, massInput);
        
        //Radius Label
        Label radius = new Label("Radius:");
        radius.setId("radius");
        
        //Radius Input
        TextField radiusInput = new TextField();
        radiusInput.setPromptText("radius value");
        radiusInput.setId("radiusInput");
        
        //creates row 3
        row3.getChildren().addAll(radius, radiusInput);
        
        //Torsional Constant 
        Label tConstant = new Label("Torsional Constant:");
        tConstant.setId("tConstant");
        
        //Torsional Constant input
        TextField tConstantInput = new TextField("1");
        tConstantInput.setPromptText("torsional constant value");
        tConstantInput.setId("tConstantInput");
        
        //creates row 4
        row4.getChildren().addAll(tConstant, tConstantInput);
        
        //Height constant input
        Label height = new Label("Height:");
        height.setId("height");
        
        //Height input
        TextField heightInput = new TextField();
        heightInput.setPromptText("height value");
        heightInput.setId("heightInput");
        
        //creates row 5
        row5.getChildren().addAll(height, heightInput);
        
        //Width constant input
        Label width = new Label("Width:");
        width.setId("width");
         
        //Width input
        TextField widthInput = new TextField();
        widthInput.setPromptText("width value");
        widthInput.setId("widthInput");
        
        //creates row 6
        row6.getChildren().addAll(width, widthInput);
        
        //simulation button
        Button create = new Button("Enter");
        create.setId("create");
        
        //go back to main menu
        Button back = new Button("Back");
        back.setId("back");
        back.setOnAction(e -> {window.setScene(menu); window.show();});
        
        row7.getChildren().addAll(create, back);
        
        //creates layout
        layout.getChildren().addAll(nameLabel, row1, row2, row3, row4, row5, row6, row7);
        
        //display scene
        Scene barScene = new Scene(layout, 450, 500);
        barScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
        window.setScene(barScene);
        window.show();
        
        //either simulates using input data or reprompts user by displaying error pop up with invalid inpuit
        create.setOnAction(e -> {
           if(!valid.barCheck(thetaInput, massInput, radiusInput, tConstantInput, heightInput, widthInput))
           {
             //redisplay scene
             Scene drScene = new Scene(layout, 450, 500);
             drScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
             window.setScene(drScene);
             window.show();
          }
          else
          {
            //move on and simulate pendelum
            PhysicalBar po = new PhysicalBar(Double.parseDouble(massInput.getText()), Double.parseDouble(radiusInput.getText()),
                 Double.parseDouble(heightInput.getText()), Double.parseDouble(widthInput.getText()));
            Lab experiment = new Lab(Double.parseDouble(thetaInput.getText()), po, Double.parseDouble(tConstantInput.getText()));
            Display d = new Display(experiment, window, menu);
            
            //Display object and control box
            window.setScene(d.getScene());
            window.show();
            ControlBox.display(window, menu, d);
          }
        });
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
        HBox row7 = new HBox(5);
        
        //title at the top
        Label nameLabel = new Label(title);
        nameLabel.setId("nameLabel");
       
        //Theta Label
        Label initT = new Label("Initial Theta:");
        initT.setId("initT");
       
        //Theta Input
        TextField thetaInput = new TextField();
        thetaInput.setPromptText("intial theta value");
        thetaInput.setId("thetaInput");
        
        //creates row one
        row1.getChildren().addAll(initT, thetaInput);
        
        //Mass Label
        Label mass = new Label("Mass:");
        mass.setId("mass");
       
        //Mass Input
        TextField massInput = new TextField();
        massInput.setPromptText("mass value");
        massInput.setId("massInput");
        
        //creates row 2
        row2.getChildren().addAll(mass, massInput);
        
        //Radius Label
        Label radius = new Label("Radius:");
        radius.setId("radius");
        
        //Radius Input
        TextField radiusInput = new TextField();
        radiusInput.setPromptText("radius value");
        radiusInput.setId("radiusInput");
        
        //creates row 3
        row3.getChildren().addAll(radius, radiusInput);
        
        //Torsional Constant 
        Label tConstant = new Label("Torsional Constant:");
        tConstant.setId("tConstant");
        
        //Torsional Constant input
        TextField tConstantInput = new TextField("1");
        tConstantInput.setPromptText("torsional constant value");
        tConstantInput.setId("tConstantInput");
        
        //creates row 4
        row5.getChildren().addAll(tConstant, tConstantInput);
        
        //Height constant input
        Label height = new Label("Height:");
        height.setId("height");
         
        //Height input
        TextField heightInput = new TextField();
        heightInput.setPromptText("height value");
        heightInput.setId("heightInput");
        
        //creates row 5
        row6.getChildren().addAll(height, heightInput);
        
        //simulation button
        Button create = new Button("Enter");
        create.setId("create");
        
        //go back to main menu
        Button back = new Button("Back");
        back.setId("back");
        back.setOnAction(e -> {window.setScene(menu); window.show();});
        
        row7.getChildren().addAll(create, back);
        
        //creates layout
        layout.getChildren().addAll(nameLabel, row1, row2, row3, row4, row5,row6, row7);
      
            //display the scene
             Scene diskrodScene = new Scene(layout, 450, 500);
             diskrodScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
             window.setScene(diskrodScene);
             window.show();
             
        //either simulates using input data or reprompts user by displaying error pop up with invalid inpuit
        create.setOnAction(e -> {
            Lab experiment = null;
           if(!valid.diskrodCheck(thetaInput, massInput, radiusInput, tConstantInput, heightInput))
           {
             Scene drScene = new Scene(layout, 450, 500);
             drScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
             window.setScene(drScene);
             window.show();
          }
          else
          {
            String s = "Physical" + title; //create title
            PhysicalObject po = null;
            if(s.equals("PhysicalRod")) //if its a physical rod
            {
                po = new PhysicalRod(Double.parseDouble(massInput.getText()), Double.parseDouble(heightInput.getText()),
                 Double.parseDouble(radiusInput.getText()));
                experiment = new Lab(Double.parseDouble(thetaInput.getText()), po, Double.parseDouble(tConstantInput.getText()));
            }
            else
                if(s.equals("PhysicalDisk")) //if its a physical disk
                {
                    po = new PhysicalDisk(Double.parseDouble(massInput.getText()), Double.parseDouble(radiusInput.getText()),
                        Double.parseDouble(heightInput.getText()));
                    experiment = new Lab(Double.parseDouble(thetaInput.getText()), po, Double.parseDouble(tConstantInput.getText()));
                }
                    
            //Create display
            Display d = new Display(experiment, window, menu);
            
            //Display object and control box
            window.setScene(d.getScene());
            window.show();
            ControlBox.display(window, menu, d);
          }
       
        });
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
        HBox row5 = new HBox(5);
        
        //title at the top
        Label nameLabel = new Label("Sphere");
        nameLabel.setId("nameLabel");
       
        //Theta Label
        Label initT = new Label("Initial Theta:");
        initT.setId("initT");
       
        //Theta Input
        TextField thetaInput = new TextField();
        thetaInput.setPromptText("intial theta value");
        thetaInput.setId("thetaInput");
        
        //creates row one
        row1.getChildren().addAll(initT, thetaInput);
        
        //Mass Label
        Label mass = new Label("Mass:");
        mass.setId("mass");
       
        //Mass Input
        TextField massInput = new TextField();
        massInput.setPromptText("mass value");
        massInput.setId("massInput");
        
        //creates row 2
        row2.getChildren().addAll(mass, massInput);
        
        //Radius Label
        Label radius = new Label("Radius:");
        radius.setId("radius");
        
        //Radius Input
        TextField radiusInput = new TextField();
        radiusInput.setPromptText("radius value");
        radiusInput.setId("radiusInput");
        
        //creates row 3
        row3.getChildren().addAll(radius, radiusInput);
        
        //Torsional Constant 
        Label tConstant = new Label("Torsional Constant:");
        tConstant.setId("tConstant");
        
        //Torsional Constant input
        TextField tConstantInput = new TextField("1");
        tConstantInput.setPromptText("torsional constant value");
        
        //creates row 4
        row4.getChildren().addAll(tConstant, tConstantInput);
        
        //simulation button
        Button create = new Button("Enter");
        create.setId("create");
        
        //go back to main menu
        Button back = new Button("Back");
        back.setId("back");
        back.setOnAction(e -> {window.setScene(menu); window.show();});
        
        row5.getChildren().addAll(create, back);
        
        //creates layout
        layout.getChildren().addAll(nameLabel, row1, row2, row3, row4, row5);
        
        //display the scene
        Scene sphereScene = new Scene(layout, 450, 500);
        sphereScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
        window.setScene(sphereScene);
        window.show();
        
        //either simulates using input data or reprompts user by displaying error pop up with invalid inpuit
        create.setOnAction(e -> {
           if(!valid.sphereCheck(thetaInput, massInput, radiusInput, tConstantInput))
           {
               //redisplay scene
             Scene drScene = new Scene(layout, 450, 500);
             drScene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
             window.setScene(drScene);
             window.show();
          }
          else
            //move and on and simulate pendelum
           {
               //create test objects
               PhysicalSphere po = new PhysicalSphere(Double.parseDouble(massInput.getText()), Double.parseDouble(radiusInput.getText()));
               Lab experiment = new Lab(Double.parseDouble(thetaInput.getText()), po, Double.parseDouble(tConstantInput.getText()));
               Display d = new Display(experiment, window, menu);
               
            //Display object and control box
            window.setScene(d.getScene());
            window.show();
            ControlBox.display(window, menu, d);
           }   
        });
    }
}