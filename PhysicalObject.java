/**
 * Abstract class PhysicalObject - Parent class for all objects to be rotated.
 *
 * @author Omri Habot
 * @version 1.0.0
 */
public abstract class PhysicalObject
{
    protected double mass; //mass of the object in kilograms
    protected double radius; //radius (half the length) of the object in meters
    
    /**
    * Initializes the both mass and radius of the
    * object with 0.
    */
    public PhysicalObject()
    {
        mass = 0;
        radius = 0;
    }
    
    /**
    * Initializes the mass and radius of the
    * object with the passed values.
    * 
    * @param myMass the mass of the object in kilograms
    * @param myRadius the radius (half the length) of the object in meters
    */
    public PhysicalObject(double myMass, double myRadius)
    {
        mass = myMass;
        radius = myRadius;
    }
    
    /**
    * constructor PhysicalObject - initializes the mass and radius of the
    * object with the passed values.
    */
    public abstract double getInertia();
    
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
}