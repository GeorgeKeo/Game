import java.util.Set;
import java.util.HashMap;
/**
 * Goodhue's SpecialRoom
 * 
 * Adding a special capability to just one room.
 * 
 * 2013-11-15
 */
public class SpecialRoom extends Room

{
    
    private Object gurleyJersey;
    //private HashMap<String, Object> bagItems; 
    
    /**
     * Constructor for objects of class SpecialRoom
     */
    public SpecialRoom(String description)
    {
        super(description);
        
    }
    public void press(Command command)
    {
        if(command.getSecondWord().equals("ID"))
        {
            System.out.println("You swipe your ID and then a door " +
                "slides open revealing a staircase.");
            Room creepyRoom = new Room("in a creepy room");
            gurleyJersey = new Object("gurleyJersey");
            setExit("down", creepyRoom);
            creepyRoom.setExit("up", this);
            creepyRoom.setItem("gurleyJersey", gurleyJersey);
            changeDescription("in the Staff Room" +
            ". \nAn opening in the wall reveals a staircase leading down.");
        }
        
       
        else
        {
            super.press(command);
        }
        
       
    }

    
}
