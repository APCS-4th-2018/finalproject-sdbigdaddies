import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import apcslib.*;

/**
 * Acts as a control mechanism while the object is rotating
 * 
 * @author Julian Ramos
 * @version 1.0.0
 */
public class ControlBox
{
    /**
     * Displays the control window
     * @param Stage mainStage
     * @param Scene mainScene
     * @param Display theDisplay
     */
    public static void display(Stage stage, Scene main, Display d)
    {
        //Create new stage
        Stage window = new Stage();
        
        //Set up window properties
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Control");
        window.setMinWidth(300);
        window.setMinHeight(200);
        
        Label l2 = new Label("Angular Frequency: " + Format.right(d.getLab().getAngFreq(), 6, 3) + " Radians per Second");
        Label l3 = new Label("Period: " + Format.right(d.getLab().getPeriod(), 6, 3) + " Seconds");
        Label l4 = new Label("Initial Theta: " + Format.right(d.getLab().getTheta(), 6, 3) + " Radians");
        
        //Create button to exit display
        Button closeButton = new Button("Back");
        closeButton.setOnAction(event ->
        {
            stage.setScene(main);
            stage.show();
            window.close();
        });
        
        //Create button to begin rotation
        Button release = new Button("Release");
        release.setOnAction(e -> d.rotate());
        
        //Add buttons to VBox
        VBox layout = new VBox(10);
        layout.getChildren().addAll(l2, l3, l4, closeButton, release);
        layout.setAlignment(Pos.CENTER);
        
        //Display window
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}