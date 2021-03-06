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
    private double initTheta;
    private PhysicalObject p;
    /**
     * Constructor for objects of class Lab assuming user wants their own 
     * torsional constant
     */
    public Lab(double t, PhysicalObject po, double k)
    {
        // initialize instance variables
        initTheta = Math.toRadians(t);
        p = po;
        tor = k;
        angFreq = calcAngFreq();
        freq = calcFreq();
        period = calcPeriod();
        
    }
    /**
     * Constructor for objects of class Lab assuming the
     * default torsional constant
     */
    public Lab(double t, PhysicalObject po)
    {
        // initialize instance variables
        initTheta = Math.toRadians(t);
        p = po;
        tor = 1; //Lol our default value
        angFreq = calcAngFreq();
        freq = calcFreq();
        period = calcPeriod();
    }
    private double calcAngFreq()
    {
     return Math.sqrt(tor/p.getInertia()); 
    }
    private double calcFreq()
    {
      return 1/freq;
    }
    public double calctheta(double time)
    {
     return initTheta*Math.cos(angFreq*time);
    }
    private double calcPeriod()
    {
     return Math.PI*2* Math.sqrt(p.getInertia()/tor);
    }
    /**
     *Getter for the frequency of oscillation
     *
     * @return    the frequency of oscillation
     */
    public double getFreq()
    {
        return freq;
    }
    /**
     * Getter for the angle of displacement
     *
     * @return    the current angle the object is from equilibrium
     */
    public double getTheta()
    {
        return initTheta;
    }
    /**
     * getter for the angular frequency
     *
     * @return    the angular frequency of an object
     */
    public double getAngFreq()
    {
        return angFreq;
    } 
    /**
     * A getter for the object spinning
     * 
     * @return    the object's reference
     */
    public PhysicalObject getObj()
    {
     return p;
    }
    /**
     * A getter for the period of the object
     * 
     * @return    period
     */
    public double getPeriod()
    {
     return period;
    }
}
