import java.util.Set;
import java.util.HashMap;
/**
 * Write a description of class SpecialRoomOar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialRoomOar extends Room
{
    // instance variables - replace the example below with your own

    private Object oar;

    public SpecialRoomOar(String description)
    {
        super(description);
    }

    public void press(Command command)
    {
        if(command.getSecondWord().equals("case"))

        {
            System.out.println("You open the case, and you see " +
                "some stairs leading down..");

            Room oarRoom = new Room("in a hallway with a shining light at the end of it."
                    + "Upon closer inspection, you see that the light is shining from"
                    + "the GA/FL Oar case"
                    + "There is a sign above it, reading 'no fighting in the Oar Room'");
            oar = new Object ("Oar");	 
            setExit("down", oarRoom);
            oarRoom.setExit("up", this);
            oarRoom.setItem("Oar", oar);
            changeDescription("in the corridor" +
                ".  \nThe GA/FL Oar case is open revealing a staircase leading down.");
        }
        else
        {
            super.press(command);
        }
    }
}