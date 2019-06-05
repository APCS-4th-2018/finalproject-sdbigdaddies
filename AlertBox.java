
/**
 * Write a description of class AlertBox here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.application.*;
public class AlertBox
{
     public void display(VBox layout) 
    {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ERROR: Input");
        window.setMinWidth(250);

        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> window.close());
        
        layout.getChildren().add(closeButton);
        
        layout.setAlignment(Pos.CENTER);
        
        
        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
    }
}
