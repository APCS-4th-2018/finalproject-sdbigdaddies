import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

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
        layout.getChildren().addAll(closeButton, release);
        layout.setAlignment(Pos.CENTER);
        
        //Display window
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}