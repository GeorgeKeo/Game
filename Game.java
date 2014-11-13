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
 * Additions to Zuul - So far, we've added a lot of rooms to the original game. We still have to name them, and add a few more rooms. 
 *
 *
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room jitteryJoes, room2, room3, room4, room5, room6, room7, room8, room9, room10, room11, room12, room13, room14, room15;
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
        room2 = new Room("in a lecture theater");
        room3 = new Room("in a lecture theater");
        room4 = new Room("in a lecture theater");
        room5 = new Room("in a lecture theater");
        room6 = new Room("in a lecture theater");
        room7 = new Room("in a lecture theater");
        room8 = new Room("in a lecture theater");
        room9 = new Room("in a lecture theater");
        room10 = new Room("in a lecture theater");
        room11 = new Room("in a lecture theater");
        room12 = new Room("in a lecture theater");
        room13 = new Room("in a lecture theater");
        room14 = new Room("in a lecture theater");
        room15 = new Room("in a lecture theater");

        staffRoom = new SpecialRoom("in the Staff Room" +
            ".  There is a button on the desk.");

        // initialise room exits
        jitteryJoes.setExit("north", room2);
        jitteryJoes.setExit("south", room5);

        room2.setExit("south", jitteryJoes);
        room2.setExit("west", room7);
        room2.setExit("east", room3);

        room7.setExit("south", room8);
        room7.setExit("east", room2);
        room4.setExit("north", room9);

        room3.setExit("west", room2);
        room3.setExit("east", room4);

        room4.setExit("west", room3);

        room5.setExit("north", jitteryJoes);
        room5.setExit("south", room6);

        room6.setExit("north", room5);

        room8.setExit("north", room7);
        room8.setExit("south", staffRoom);

        room9.setExit("north", room10);
        room9.setExit("south", room8);

        room10.setExit("north", room11);
        room10.setExit("east", room12);

        room11.setExit("west", room15);
        room11.setExit("south", room10);

        room12.setExit("north", room15);
        room12.setExit("east", room13);

        room13.setExit("west", room12);
        room13.setExit("north", room14);

        room14.setExit("south", room13);
        room14.setExit("west", room15);

        room15.setExit("east", room14);
        room15.setExit("west", room11);
        room10.setExit("south", room12);

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
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
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
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
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
