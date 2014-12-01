import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Object> items;
    private Creature zombies;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new HashMap<String, Object>();
        zombies = new Creature ("zombie", 0);
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String longDesc = "";
        if( getZombieNumber() <= 0)
        {
            longDesc = "You are " + description + ".\n" + getExitString() + ".\n" + getItemString() + " " +  ".\n" + getZombieString();
        }
        
        if(getZombieNumber() > 0)
        {
            longDesc = "You are " + description +  ".\n" + getItemString() + ".\n" + getZombieString();
        }
        
        return longDesc;
        
    }
    
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public String getItemString()
    {
        String returnString = "Items:";
        Set<String> keys = items.keySet();
        for (String item : keys){
            returnString += " " + item;
        }
        return returnString; 
    }

    public String getZombieString()
    {
        if(zombies == null){
            return ("There are no zombies in this room.");
        }

        else {
            return ("There are " + zombies.getNumber() + " zombies in the room.");
        }
    }

    public String getItemName()
    {
        String returnString = "";
        Set<String> keys = items.keySet();
        for (String item : keys){
            returnString = item;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public void press(Command command)
    {
        System.out.println("Do What?");
    }

    public void changeDescription(String newDescription)
    {
        description = newDescription;
    }

    /**
     * Define an item from this room.
     * @param name The name of item
     * @param item  The the item to add 
     */
    public void setItem(String name, Object item) 
    {
        items.put(name, item);
    }

    public void setZombies(int number)
    {
        zombies = new Creature("zombie", number);
    }

    public int getZombieNumber()
    {
        return zombies.getNumber();
    }

}

