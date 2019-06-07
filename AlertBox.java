
/**
 * Write a description of class AlertBox here.
 * pops up an alert window that shows the user which input values are invalid
 * @author (David Glozman)
 * @version (6/19)
 */
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.application.*;
public class AlertBox
{
    /**
     * displays the passed layout as a window and displays which inputs are invalid
     * @param layout object with labels that represent invalid input
     */
     public void display(VBox layout) 
    {
        //local variable
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ERROR: Input");
        window.setMinWidth(250);

        //close button
        Button closeButton = new Button("Close this window");
        closeButton.setId("closeButton");
        closeButton.setOnAction(e -> window.close());
        
        //add to layout
        layout.getChildren().add(closeButton);
        
        //center it 
        layout.setAlignment(Pos.CENTER);
        
        
        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("FXStyling.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
    }
}