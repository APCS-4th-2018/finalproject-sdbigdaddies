
/**
 * This is the calss modeling the current lab set up the user desires before
 * the simulation begins
 *
 * @author (Nico Cereghini)
 * @version (5/28/2019)
 */
public class Lab
{
    // instance variables - replace the example below with your own
    private double angFreq;
    private double freq;
    private double period;
    private double tor; //torsional constant
    private double alpha;
    private double theta;
    private PhysicalObject p;
    /**
     * Constructor for objects of class Lab assuming user wants their own 
     * torsional constant
     */
    public Lab(double t, PhysicalObject po, double k)
    {
        // initialize instance variables
        theta = t;
        p = po;
        tor = k;
    }
    /**
     * Constructor for objects of class Lab assuming the
     * default torsional constant
     */
    public Lab(double t, PhysicalObject po)
    {
        // initialize instance variables
        theta = t;
        p = po;
        tor = 1; //Lol our default value
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double calcAngFreq()
    {
        // put your code here
        return x + y;
    }
    public double calcFreq()
    {}
    public double calcAlpha()
    {}
    public double calcPeriod()
    {}
    public double getFreq()
    {}
    public double getAlpha()
    {}
    public double getFreq()
    {}
    
}
