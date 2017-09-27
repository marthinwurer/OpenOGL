import java.util.ArrayList;
import java.util.Iterator;

public class InitiativeList implements Iterable<Character> {

    private ArrayList<Character> characters;
    private int curr_index;

    public InitiativeList() {
        this.characters = new ArrayList<>();
        this.curr_index = 0;

    }

    public InitiativeList add(Character toAdd) {
        int add_index = 0;
        // A good ol' one liner. The length check guards the index.
        for (; add_index < characters.size() &&
                characters.get(add_index).initiativeCompare(toAdd) > 0;
             add_index++)
            ;
        characters.add(add_index, toAdd);

        // if we add the character before the current one, increment the
        // current one so that they don't take another turn
        if (add_index < curr_index) {
            curr_index++;
        }

        return this; // make it easier to chain calls together
    }


    public InitiativeList addAfter(Character toAdd, Character after) {

        int add_index = 0;
        // iterate through all the characters in the list. If the character to add after is not found, throw an exception
        for (; add_index < characters.size(); add_index++) {
            if (characters.get(add_index) == after){
                characters.add(add_index+1,toAdd);
                return this;
            }
        }
        // if no characters match the one to add after, throw an exception
        throw new IndexOutOfBoundsException("Character Not found: "+after);

    }

    public int size() {
        return characters.size();
    }

    public boolean isEmpty() {
        return characters.isEmpty();
    }

    public InitiativeList clear() {
        characters.clear();
        curr_index = 0;
        return this;
    }

    public Character get() {
        return characters.get(curr_index);
    }

    /**
     * Move the current character to the next character in the initiative line.
     * If the inititative has looped around, return true.
     * @return true if the inititive order has looped around
     */
    public boolean next(){
        int old_index = curr_index;
        curr_index = (curr_index + 1) % characters.size();
        return old_index > curr_index;
    }

    public Iterator<Character> iterator() {
        return characters.iterator();
    }
}
