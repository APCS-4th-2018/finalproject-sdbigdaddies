public abstract class MainThread extends Thread
{
    protected Object obj;
    
    public MainThread()
    {
        obj = null;
    }
    
    public MainThread(Object thing)
    {
        obj = thing;
    }
    
    @Override
    public abstract void run();  
    
    public Object getObj()
    {
        return obj;
    }
    
    public Object setObj(Object newThing)
    {
        Object oldThing = obj;
        obj = newThing;
        return oldThing;
    }
}
