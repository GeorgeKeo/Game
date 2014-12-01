
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
                    + "Upon closer inspection, you see that the light is shining up the GA/FL Oar case"
                    + "There is a sign above it, reading 'no fighting in the Oar Room'");
            oar = new Object ("GA/FL Oar");	 
            setExit("downstairs", oarRoom);
            oarRoom.setItem("GA/FL Oar", oar);
            oarRoom.setExit("up", this);
            changeDescription("in the corridor" +
                ".  \nThe GA/FL Oar case is open revealing a staircase leading down.");
        }
    }
}