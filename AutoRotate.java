import javafx.scene.Group;
import javafx.scene.transform.Rotate;

public class AutoRotate extends MainThread
{
    private Group group;
    private Lab lab;
    
    public AutoRotate(Group g, Lab l)
    {
        group = g;
        lab = l;
    }
    
    @Override
    public void run()
    {
        double start = System.currentTimeMillis();
        double lastRotation = lab.getTheta(), rotation = 0;
        
        while(true)
        {
            rotation = lab.calctheta(System.currentTimeMillis() - start);
            group.getTransforms().add(new Rotate(rotation - lastRotation, Rotate.Y_AXIS));
            lastRotation = rotation;
        }
    }
}
