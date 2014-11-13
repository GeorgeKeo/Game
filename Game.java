/**
 * TEST GIT HUB
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room jitteryJoes, room2, room3, room4, room5, room6, room7, room8, room9, room10, room11;

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
        jitteryJoes = new Room("jitteryJoes");
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
        

        office = new SpecialRoomOffice("in the computing admin office" +
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
        
        room9.setExit("north", room10);
        room9.setExit("south", room8);
        
        room10.setExit("north", room11);

       

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
        else if (commandWord.equals("press")) {
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
