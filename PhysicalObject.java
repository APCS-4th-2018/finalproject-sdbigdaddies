/**
 * Abstract class PhysicalObject - Parent class for all objects to be rotated.
 *
 * @author Omri Habot
 * @version 1.0.0
 */
public abstract class PhysicalObject
{
    protected double mass; //mass of the object in kilograms
    protected double height; //height of the object in meters
    protected double radius; //radius (half the length) of the object in meters
    /**
    * Initializes the both mass and radius of the
    * object with 0.
    */
    public PhysicalObject()
    {
        mass = 0;
        radius = 0;
        height = 0;
    }
    
    /**
    * Initializes the mass and radius of the
    * object with the passed values.
    * 
    * @param myMass the mass of the object in kilograms
    * @param myRadius the radius (half the length) of the object in meters
    */
    public PhysicalObject(double myMass, double myRadius, double myHeight)
    {
        mass = myMass;
        radius = myRadius;
        height = myHeight;
    }
    
    /**
    * Returns the value for the moment of inertia of the object in terms 
    * of kilograms and meters.
    * 
    * @return the moment of inertia of the object.
    */
    public abstract double getInertia();
    
    /**
     * Returns the name of the type of object.
     * 
     * @return the name of the type of object
     */
    public abstract String type();
    
    /**
    * Sets the new mass of the object.
    * 
    * @param myMass the mass of the object in kilograms.
    */
    public void setMass(double myMass)
    {
        mass = myMass;
    }
    
    /**
    * Returns the mass of the object.
    * 
    * @return The mass of the object in kilograms.
    */
    public double getMass()
    {
        return mass;
    }
    
    /**
    * Sets the new radius of the object.
    * 
    * @param myRadius the radius (half the length) of the object in meters.
    */
    public void setRadius(double myRadius)
    {
        radius = myRadius;
    }
    
    /**
    * Returns the radius of the object.
    * 
    * @return The radius (half the length) of the object in meters.
    */
    public double getRadius()
    {
        return radius;
    }
    
    /**
    * Sets the new height of the object.
    * 
    * @param myHeight the height of the object in meters.
    */
    public void setHeight(double myHeight)
    {
        height = myHeight;
    }
    
    /**
    * Returns the height of the object.
    * 
    * @return The height of the object in meters.
    */
    public double getHeight()
    {
        return height;
    }
}
