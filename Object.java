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

    /**
     * Constructor for objects of class Object
     */
    public Object()
    {
        
    }

   private int rng(int size)
   {
       Random rng = new Random();
       int randomInt = rng.nextInt(size);
       return randomInt;
       
   }
}
