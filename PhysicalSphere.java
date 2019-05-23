
/**
 * Abstract class PhysicalSphere - Sphere object to be rotated in the pendulum.
 *
 * @author Omri Habot
 * @version 1.0.0
 */
public class PhysicalSphere extends PhysicalObject
{
    /**
    * Initializes the mass and radius of the
    * object with the passed values.
    * 
    * @param myMass the mass of the object in kilograms
    * @param myRadius the radius (half the length) of the object in meters
    */
    public PhysicalSphere(double myMass, double myRadius)
    {
        super(myMass, myRadius);
    }
    
    public double getInertia()
    {
        return Math.pow(radius, 2) * mass * 0.4;
    }
}
