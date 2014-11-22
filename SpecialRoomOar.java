
/**
 * Write a description of class SpecialRoomOar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialRoomOar extends Room
{
    // instance variables - replace the example below with your own
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
            + "Upon closer inspection, you see that the light is shining up the GA/FL Oar case");
            setExit("downstairs", oarRoom);
            oarRoom.setExit("up", this);
            changeDescription("in the corridor" +
            ".  \nThe GA/FL Oar case is open revealing a staircase leading down.");
        }
    }
}