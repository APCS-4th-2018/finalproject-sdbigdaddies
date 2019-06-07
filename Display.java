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

/**
 * Class capable of displaying rotating objects
 */
public class Display
{
    //Initialize display size
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Lab lab; //Lab for getting values for the simulation
    private Stage window; //Display of the lab
    private Scene menu; //Menu window for the lab
    private Group group; //Object/group being rotated
    
    /**
     * Create new Display class
     * @param Lab lab
     * @param Stage stage
     * @param Scene mainScene
     */
    public Display(Lab l, Stage passedStage, Scene main)
    {
        lab = l;
        window = passedStage;
        menu = main;
    }
    
    /**
     * Returns the scene with objects
     */
    public Scene getScene()
    {
        //Set up group and scene
        group = new Group();
        
        createObject(group);
        
        Scene scene = new Scene(group, WIDTH, HEIGHT, true, SceneAntialiasing.BALANCED);
        
        //Stuff that can be used
        /*
        group.getTransforms().add(new Rotate(10, Rotate.X_AXIS));
        group.getTransforms().add(new Rotate(10));
        group.getTransforms().add(new Rotate(10, Rotate.Y_AXIS));
        group.getTransforms().add(new Translate(0, 10));
        group.getTransforms().add(new Translate(0, 0, 10));
        box.setMaterial(new PhongMaterial(new Color(Math.random(), Math.random(), Math.random(), 1.0)));
        */
        
       //Return the new scene
        return scene;
    }
    
    //Creates and sets up the object in the group
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
        //Set up rotation object
        Rotate r = null;
        Transform tr = new Rotate();
        
        //Rotate to next thetas
        for(double t = 0; t < 1000; t += 0.1)
        {
            suspend();
            
            //rotate according to the function calctheta in lab
            r = new Rotate((lab.calctheta(System.currentTimeMillis())), Rotate.Y_AXIS);
            tr = tr.createConcatenation(r);
            tr.createConcatenation(new Rotate(10, Rotate.X_AXIS));
            group.getTransforms().clear();
            group.getTransforms().add(tr);
        }
    }
    
    //Pauses for a very short while
    private void suspend()
    {
        for(int i = 0; i < 10000; i++)
            i += 3/3.0;
    }
}
