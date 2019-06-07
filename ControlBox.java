import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ControlBox
{
    public static void display(Stage stage, Scene main, Display d)
    {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Control");
        window.setMinWidth(300);
        window.setMinHeight(200);
        
        Button closeButton = new Button("Back");
        closeButton.setOnAction(event ->
        {
            stage.setScene(main);
            stage.show();
            window.close();
        });
        Button release = new Button("Release");
        release.setOnAction(e ->
        {
            d.rotate();
        });
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(closeButton, release);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}