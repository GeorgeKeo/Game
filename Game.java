/**
 *
 * GATOR HATERS
 * -The Dragons
 * 
 * Mashfik Ahmed, George Keohavong, Mike Burruss
 * 
 * This game is about a character who wakes up in the middle of the University of Georgia campus and realizes that everyone has slowly turned into zombies.
 * He finds out that this has occurred because a villianous coach at the University of Florida has a machine that 
 * creates a mutated Gatorade (called ZombieAde), which turns drinkers into idiotic Flordia fans, aka Zombies. 
 * The hero must travel through campus and find this machine and destroy it before it is too late. 
 * 
 * Additions to Zuul - So far, we've added a lot of rooms to the original game. We changed the command from "press" to "swipe" for ID cards.
 * 
 * 
 *
 *
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room jitteryJoes, eastStudyRoom, corridor, westWing, cafe, northEntrance, smokingArea, mezzanine, bridge, tateEntrance1, tateEntrance2, neHall, nwHall, swHall, seHall;
    private Room staffRoom;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room jitteryJoes, theater, pub, lab, office;

        // create the rooms
        jitteryJoes = new Room("in Jittery Joes");
        eastStudyRoom = new Room("in the East Study Room. All of the private study rooms are destroyed.");
        corridor = new Room("in a corridor between the East Study Room and the West Wing");
        westWing = new Room("in the West Wing.");
        cafe = new Room("in the cafe");
        northEntrance = new Room("at the North Entrance to MLC.");
        smokingArea = new Room("in the smoking area. There are a lot of cigarette butts everywhere...");
        mezzanine = new Room("in the mezzanine. There seems to be a small door to the north...");
        bridge = new Room("on the bridge between Tate and MLC. Seems a little shaky...");
        tateEntrance1 = new Room("at the first entrance of Tate");
        tateEntrance2 = new Room("at the second entrance of Tate");
        neHall = new Room("in the North East Hall of Tate");
        nwHall = new Room("in the North West Hall of Tate");
        swHall = new Room("in the South West Hall of Tate");
        seHall = new Room("in the South East Hall of Tate");

        staffRoom = new SpecialRoom("in the Staff Room" +
            ".  There is a slot for your ID card.");

        // initialise room exits
        jitteryJoes.setExit("south", eastStudyRoom);
        jitteryJoes.setExit("north", cafe);

        eastStudyRoom.setExit("north", jitteryJoes);
        eastStudyRoom.setExit("east", smokingArea);
        eastStudyRoom.setExit("west", corridor);

        smokingArea.setExit("north", mezzanine);
        smokingArea.setExit("west", eastStudyRoom);
        westWing.setExit("south", bridge);

        corridor.setExit("east", eastStudyRoom);
        corridor.setExit("west", westWing);

        westWing.setExit("east", corridor);

        cafe.setExit("south", jitteryJoes);
        cafe.setExit("north", northEntrance);

        northEntrance.setExit("south", cafe);

        mezzanine.setExit("south", smokingArea);
        mezzanine.setExit("north", staffRoom);

        bridge.setExit("south", tateEntrance1);
        bridge.setExit("north", mezzanine);

        tateEntrance1.setExit("north", tateEntrance2);
        tateEntrance1.setExit("east", neHall);

        tateEntrance2.setExit("west", seHall);
        tateEntrance2.setExit("south", tateEntrance1);

        neHall.setExit("north", seHall);
        neHall.setExit("east", nwHall);

        nwHall.setExit("west", neHall);
        nwHall.setExit("north", swHall);

        swHall.setExit("south", nwHall);
        swHall.setExit("west", seHall);

        seHall.setExit("east", swHall);
        seHall.setExit("west", tateEntrance2);
        tateEntrance1.setExit("south", neHall);
        
        staffRoom.setExit("north", mezzanine);

        currentRoom = jitteryJoes;  // start game jitteryJoes
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("You wake up in a daze...'How did I get here?' you ask yourself");
        System.out.println("You sit up and realize you are at Jittery Joes inside of the MLC");
        System.out.println("But something is different...everything seems...post-apocolyptic.");
        System.out.println("You see the words 'Gator Hater' written in blood on the wall but that makes no sense to you");
        System.out.println("You stand up and decide it is time to start your journey...");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("swipe")) {
            currentRoom.press(command);
            System.out.println(currentRoom.getLongDescription());
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are wandering around the university.");
        System.out.println("You have to find. . . ");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

}
