import java.util.Iterator;

public class CircularInitiativeList implements Iterable<Character> {

    private class CharacterIterator implements Iterator<Character>{

        private int left;
        Node current;
        CharacterIterator(Node head, int size){
            this.current = head;
            this.left = size - 1;
        }

        @Override
        public boolean hasNext() {
            return left > 0;
        }

        @Override
        public Character next() {
            Character temp = current.data;
            current = current.next;
            left--;
            return temp;
        }
    }

    @Override
    public Iterator<Character> iterator() {
        return new CharacterIterator(head, size);
    }

    private class Node{
        Node previous;
        Node next;
        Character data;

        Node(Node previous, Node next, Character data){
            this.previous = previous;
            this.next = next;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node: " + data.toString();
        }
    }

    private Node head;
    private int size;

    public CircularInitiativeList(){
        size = 0;
        head = null;
    }

    public CircularInitiativeList add(Character toAdd){
        // if head is null, then make a new node that loops to itself and add it to the list
        if( head == null){
            head = new Node(null, null, toAdd);
            head.previous = head;
            head.next = head;
        }
        /*
            Characters act in order, counting down from highest result to lowest
         */
        else{
            Node current = head;

            // I need to check if it fits between the current and the next, not just if it is bigger than the current one, because not all searches start from the top.
            while(true){
//            while ( current.data.initiativeCompare(toAdd) > 0 &&
//                    current.data.initiativeCompare(current.next.data) < 0){ // make sure you don't loop around
                int diffadd = ( current.data.initiativeCompare(toAdd) );
                Character next = current.next.data;
                int diffnext = current.data.initiativeCompare(next);
                boolean cont = ( diffadd > 0 && diffnext < 0); // make sure you don't loop around
                if( !cont) break;
                current = current.next;
            }
            // loop breaks when it should be before the current char
            Node temp = new Node(current.previous, current, toAdd);
            current.previous.next = temp;
            current.previous = temp;
        }
        this.size++;
        return this;
    }

    public CircularInitiativeList addAfter(Character toAdd, Character after){

        // if there is no character to add after, throw an exception
        if( head == null){
            throw new IndexOutOfBoundsException("Empty list");
        }

        // iterate through all the characters in the list. If the character to add after is not found, throw an exception
        Node current = this.head;
        for( int ii = 0; ii < this.size; ii++, current = current.next){

            if(current.data == after){ // TODO: equals
                current.next = new Node(current, current.next, toAdd);
                current.next.next.previous = current.next;
                this.size ++;
                return this;
            }

        }

        // if no characters match the one to add after, throw an exception
        throw new IndexOutOfBoundsException("Character Not found: " + after);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return !( this.size > 0);
    }

    public CircularInitiativeList clear() {
        this.size = 0;
        this.head = null;
        return this;
    }

    public Character get() {
        if(size > 0) {
            return head.data;
        }
        else{
            return null;
        }
    }

    /**
     * Move the head to the next character in the initiative line. If the inititative has looped around, return true.
     * @return true if the inititive order has looped around
     */
    public boolean next(){
        // if size is zero or 1, return true and change nothing.
        if( size < 2){
            return true;
        }

        // otherwise, switch and compare
        this.head = this.head.next;

        return this.head.data.initiativeCompare(this.head.previous.data) < 0;
    }

    public Character remove() {
        return null;
    }

}
