import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Display
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Lab lab;
    private Stage window;
    private Scene menu;
    
    public Display(Lab l, Stage passedStage, Scene main)
    {
        lab = l;
        window = passedStage;
        menu = main;
    }
    
    public Scene getScene()
    {
        Group group = new Group();
        
        createObject(group);
        
        Scene scene = new Scene(group, WIDTH, HEIGHT, true, SceneAntialiasing.BALANCED);
        
        /*
        group.getTransforms().add(new Rotate(10, Rotate.X_AXIS));
        group.getTransforms().add(new Rotate(10));
        group.getTransforms().add(new Rotate(10, Rotate.Y_AXIS));
        group.getTransforms().add(new Translate(0, 10));
        group.getTransforms().add(new Translate(0, 0, 10));
        box.setMaterial(new PhongMaterial(new Color(Math.random(), Math.random(), Math.random(), 1.0)));
        */
        
        new AutoRotate(group, lab).start();
        
        return scene;
    }
    
    private void createObject(Group group)
    {
        PhysicalObject pO = lab.getObj();
        Shape3D s = null;
        
        switch(pO.type())
        {
            case "bar":
                s = new Box(((PhysicalBar) pO).getRadius() * 10, ((PhysicalBar) pO).getHeight() * 10, ((PhysicalBar) pO).getWidth() * 10);
                break;
            case "disk":
                s = new Cylinder(((PhysicalDisk) pO).getRadius() * 10, ((PhysicalDisk) pO).getHeight() * 10);
                break;
            case "rod":
                s = new Cylinder(((PhysicalRod) pO).getRadius() * 10, ((PhysicalRod) pO).getHeight() * 10);
                s.getTransforms().add(new Rotate(90));
                break;
            case "sphere":
                s = new Sphere(((PhysicalSphere) pO).getRadius() * 10);
                break;
        }
        
        s.setMaterial(new PhongMaterial(Color.RED));
        
        group.getChildren().add(s);
        
        //group.translateZProperty().set(200);
        group.translateXProperty().set(WIDTH / 2);
        group.translateYProperty().set(HEIGHT / 2);
        
        group.getTransforms().add(new Rotate(10, Rotate.X_AXIS));
    }
}
