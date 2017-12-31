import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by benjamin on 10/3/16.
 *
 * TODO:
 * Make world tiled with a hashmap
 * Make a world viewer (just simple 2d graphics)
 * Implement the rest
 */
public class World {

    private static Dice diceSet = new Dice();


    private ArrayList<Character> characters; // a simple list of all characters in the world

    private InitiativeList currchar; // the list of characters in initiative order
    private Tile[][] map;

    private boolean initCaclulated;

    public World(){
        characters = new ArrayList<>();
        map = new Tile[10][10];
        for (Tile[] aMap : map) {
            Arrays.fill(aMap, Tile.FLOOR);
        }
        currchar = new InitiativeList();
        initCaclulated = false;
    }

    public World addCharacter(Character toAdd){
        return addCharacter(toAdd, null);
    }

    public World addCharacter(Character toAdd, Character after){
        characters.add(toAdd);
        if( initCaclulated ) {
            // slot the character into initiative order
            if( after == null){
                // calculate the initiative, then loop through and insert the character into the right spot
                toAdd.genInitiative(diceSet);
                currchar.add(toAdd);
            }
            else {
                currchar.addAfter(toAdd, after);
            }
        }
        return this;
    }

    public World calcInitiatives(){
        for(Character c : characters){
            c.genInitiative(diceSet);
            currchar.add(c);

        }
        return this;
    }

    public void displayWorld(){

        StringBuilder outString = new StringBuilder();

        for( int yy = 0; yy < map.length; yy++){
            for( int xx = 0; xx < map[0].length; xx++){

                boolean occupied = false;
                for( Character c : characters){
                    if( c.getX() == xx && c.getY() == yy){
                        occupied = true;
                    }
                }

                if( occupied ){
                    outString.append("C");
                }
                else{
                    outString.append(" ");
                }
            }

            outString.append("\n");
        }

        // get the characters in the intiative order, and display them
        for(Character c: currchar){
            outString.append(c.getName() + "\t" + c.getInitiative() + "\n");
        }

        System.out.print(outString);
    }

    public int getHeight(){
        return map.length;
    }

    public int getWidth(){
        return map[0].length;
    }

    public Tile getTile(int xx, int yy){
        return map[yy][xx];
    }

    public Character getCurrentCharacter(){
        return currchar.get();
    }

    /**
     * Gets the next character in the initiative list for the given tile.
     * @param xx
     * @param yy
     * @return The next character to move in the given tile. null if nonexistant.
     */
    public Character getHighestPriorityCharacter(int xx, int yy){
        Character best = null;
        int count = 0;
        for( Character c : characters){
            if( c.getX() == xx && c.getY() == yy){
                count++;
                if ( best == null || (currchar.get().initiativeCompare(c) >= 0 && c.initiativeCompare(best) > 0)){
                    best = c;
                }
            }
        }

        return best;
    }

    public Pair<Character, Integer> getHighestPriorityCharacterAndCount(int xx, int yy){
        Character best = null;
        int count = 0;
        for( Character c : characters){
            if( c.getX() == xx && c.getY() == yy){
                count++;
                if ( best == null || (currchar.get().initiativeCompare(c) >= 0 && c.initiativeCompare(best) > 0)){
                    best = c;
                }
            }
        }

        return new Pair<>(best, count);
    }



}
