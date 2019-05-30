
/**
 * Abstract class PhysicalBar - Bar object to be rotated in the pendulum.
 *
 * @author Omri Habot
 * @version 1.0.0
 */
public class PhysicalBar extends PhysicalObject
{
    private double width; //width of the prism
    
    /**
    * Initializes the mass and radius of the
    * object with the passed values.
    * 
    * @param myMass the mass of the object in kilograms.
    * @param myRadius the radius (half the length) of the object in meters.
    * @param myWidth the width of the object in meters.
    * @param myHeight the height of the object in meters.
    */
    public PhysicalBar(double myMass, double myRadius, double myHeight, double myWidth)
    {
        super(myMass, myRadius, myHeight);
        width = myWidth;
    }
    
    /**
     * Returns the value of the moment of inertia of the object in terms
     * of kilograms and meters.
     * 
     * @return inertia the moment of inertia of the object.
     */
    public double getInertia()
    {
        return mass / 12 * (Math.pow(width, 2) + Math.pow(2 * radius, 2));
    }
    
    /**
     * Returns the name of the type of object.
     * 
     * @return the name of the type of object
     */
    public String type()
    {
        return "bar";
    }
    
    /**
    * Sets the new width of the object.
    * 
    * @param width The width of the object in meters.
    */
    public void setWidth(double myWidth)
    {
        width = myWidth;
    }
    
    /**
    * Returns the radius of the object.
    * 
    * @return The width of the object in meters.
    */
    public double getWidth()
    {
        return width;
    }
}
