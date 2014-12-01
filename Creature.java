
/**
 * Write a description of class Zombies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature
{
    private String name;
    private int numCreatures;

    /**
     * Constructor for objects of class Zombies
     */
    public Creature()
    {
        numCreatures = 0;
    }

    public Creature(String pName, int pNumber)
    {
        numCreatures = pNumber;
        name = pName;
    }

    public void setName(String pName)
    {
        name = pName;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setNumber(int pNumber)
    {
        numCreatures = pNumber;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getNumber()
    {
        return numCreatures;
    }
    
    
}
