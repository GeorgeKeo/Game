import java.util.Set;
import java.util.HashMap;
/**
 * Write a description of class SpecialRoomHall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialRoomHall extends Room
{
    public SpecialRoomHall(String description)
    {
        super(description);
    }
    public void press(Command command)
    {
        if(command.getSecondWord().equalsIgnoreCase("button"))
        
        {
            
            
            System.out.println("The Oar shines with power!  \nThe gateway powers up!  \nDo you want to go through the gateway? ");
            Room grandHall = new Room("are in the Grand Hall! "
            + "\nThe Gator Hater machine is running in the middle of the room");
            setExit("through", grandHall);
            changeDescription("in the hallway" +
            ".  \nThe portal is running.");
           
           
               
            
        
        }
        else
        {
            super.press(command);
        }
    }
}

