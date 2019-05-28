
/**
 * Abstract class PhysicalBar - Bar object to be rotated in the pendulum.
 *
 * @author Omri Habot
 * @version 1.0.0
 */
public class PhysicalBar extends PhysicalObject
{
    /**
    * Initializes the mass and radius of the
    * object with the passed values.
    * 
    * @param myMass the mass of the object in kilograms.
    * @param myRadius the radius (half the length) of the object in meters.
    */
    public PhysicalBar(double myMass, double myRadius)
    {
        super(myMass, myRadius);
    }
    
    /**
     * Returns the value of the moment of inertia of the object in terms
     * of kilograms and meters.
     * 
     * @return inertia the moment of inertia of the object.
     */
    public double getInertia()
    {
        return Math.pow(radius, 2) * mass * 0.4;
    }
}
