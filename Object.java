import java.util.Random;
/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object
{
    public Object nerfGun, GaFlOar, Flashlight, nerfDarts, dawgTreats, batteries, gurleyJersey;   
    
    private String name;
    private int numberItems;
    
    /**
     * Constructor for objects of class Object
     */
    public Object(String pName)
    {
       name = pName; 
       numberItems = 0;
    }
    
    public void setNumber(int number)
    {
        numberItems = number;
    }
    
    public int getNumberItems()
    {
        return numberItems;
    }
    
    public String getName()
    {
        return name;
    }
    
   private int rng(int size)
   {
       Random rng = new Random();
       int randomInt = rng.nextInt(size);
       return randomInt;
       
   }
}
