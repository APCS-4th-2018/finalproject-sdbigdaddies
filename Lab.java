
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
     return tor/p.getInertia(); 
    }
    public double calcFreq()
    {
      return 1/freq;
    }
    public double calcAlpha()
    {
     return -(Math.pow(angFreq, 2))*theta*1;
    }
    public double calcPeriod()
    {
     return Math.PI*2* Math.sqrt(p.getInertia()/angFreq);
    }
    public double getFreq()
    {
        return freq;
    }
    public double getAlpha()
    {
        return alpha;
    }
    public double getAngFreq()
    {
        return angFreq;
    }
    
}
