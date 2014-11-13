
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
            setExit("down", creepyRoom);
            creepyRoom.setExit("up", this);
            changeDescription("in the Staff Room" +
            ".  \nThere is a slot for you to swipe your ID." +
            "\nAn opening in the wall reveals a staircase leading down.");
        }
        else
        {
            super.press(command);
        }
    }

    
}
