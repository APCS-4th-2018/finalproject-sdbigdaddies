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
import javafx.scene.transform.Transform;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Display
{
    //initialize display size
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Lab lab; //lab for getting values for the simulation
    private Stage window; //display of the lab
    private Scene menu; //menu window for the lab
    private Group group; //the object/group being rotated
    
    public Display(Lab l, Stage passedStage, Scene main)
    {
        lab = l;
        window = passedStage;
        menu = main;
    }
    
    public Scene getScene()
    {
        group = new Group();
        
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
        
        return scene;
    }
    
    private void createObject(Group group)
    {
        PhysicalObject pO = lab.getObj();
        Shape3D s = null;
        
        //create the correct object requested by the user
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
        
        s.setMaterial(new PhongMaterial(Color.RED)); //set the color of the object
        
        //add the object to the group
        group.getChildren().add(s);
        
        //group.translateZProperty().set(200);
        
        //set the object to be displayed at the center
        group.translateXProperty().set(WIDTH / 2);
        group.translateYProperty().set(HEIGHT / 2);
        
        group.getTransforms().add(new Rotate(10, Rotate.X_AXIS));
    }
    /**
     * Rotates the group according to the function in the lab class.
     */
    public void rotate()
    {
        Rotate r = null;
        Transform tr = new Rotate();
        
        for(double t = 0; t < 1000; t  +=0.1)
        {
            /*try{
                Thread.sleep(500);
            }
            catch(Exception e){}*/
            
            
            //rotate according to the function calctheta in lab
            r = new Rotate((lab.calctheta(t)), Rotate.Y_AXIS);
            tr = tr.createConcatenation(r);
            group.getTransforms().clear();
            group.getTransforms().add(tr);
        }
    }
}
