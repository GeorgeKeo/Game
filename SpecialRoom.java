
/**
 * Goodhue's SpecialRoom
 * 
 * Adding a special capability to just one room.
 * 
 * 2013-11-15
 */
public class SpecialRoom extends Room

{
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
<<<<<<< HEAD
            gurleyJersey = new Object("gurleyJersey");
            setExit("down", creepyRoom);
            creepyRoom.setExit("up", this);
            creepyRoom.setItem("gurleyJersey", gurleyJersey);
=======
            setExit("down", creepyRoom);
            creepyRoom.setExit("up", this);
>>>>>>> parent of cafd844... Added items, zombies to Game Class
            changeDescription("in the Staff Room" +
            ". \nAn opening in the wall reveals a staircase leading down.");
        }
        else  if(command.getSecondWord().equals("case"))
        
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
        
       
        else
        {
            super.press(command);
        }
        
       
    }

    
}
