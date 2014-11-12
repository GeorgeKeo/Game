
/**
 * Goodhue's SpecialRoomOffice
 * 
 * Adding a special capability to just one room.
 * 
 * 2013-11-15
 */
public class SpecialRoomOffice extends Room

{
    /**
     * Constructor for objects of class SpecialRoomOffice
     */
    public SpecialRoomOffice(String description)
    {
        super(description);
    }
    public void press(Command command)
    {
        if(command.getSecondWord().equals("button"))
        {
            System.out.println("You press the button and part of the wall " +
                "slides open revealing a staircase.");
            Room cellar = new Room("in a dark and dusty cellar");
            setExit("down", cellar);
            cellar.setExit("up", this);
            changeDescription("in the computing admin office" +
            ".  \nThere is a depressed button on the desk." +
            "\nAn opening in the wall reveals a staircase leading down.");
        }
        else
        {
            super.press(command);
        }
    }

    
}
