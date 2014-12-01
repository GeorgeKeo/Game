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
            + "\nThe Gator Hater machine is running in the middle of the room." +
            "\nWill Muschamp is in front of the machine. He sees you with the oar and laughs." + "\n'Thanks for saving me the trouble of looking for it' he taunts, and advances towards you." + 
            "\nYou quickly eat the dogtreats." + "\n'Wait! NO! What are you doing!?', Muschamp panicks." + "\nYou are full of power, you swing the Oar at Muschamp,  instantly vaporizing him!" + 
            "\nMuschamp has been defeated! the machine malfunctions from lack of sustaining power and bursts into flames"
            + "\nCongratulations! You have won!!");
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

