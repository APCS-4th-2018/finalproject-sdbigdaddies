
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
        super(myMass, myRadius, 0);
    }
    
    /**
     * Returns the value of the moment of inertia of the object in terms
     * of kilograms and meters.
     * 
     * @return the moment of inertia of the object.
     */
    public double getInertia()
    {
        return Math.pow(radius, 2) * mass * 2 / 5;
    }
    
    /**
     * Returns the name of the type of object.
     * 
     * @return the name of the type of object
     */
    public String type()
    {
        return "sphere";
    }
}
