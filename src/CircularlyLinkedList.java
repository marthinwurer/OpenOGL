/**
 * Created by benjamin on 10/3/16.
 */
public class CircularlyLinkedList<E> {


    private class Node<E>{
        Node<E> previous;
        Node<E> next;
        E data;

        Node(Node<E> previous, Node<E> next, E data){
            this.previous = previous;
            this.next = next;
            this.data = data;
        }
    }

    private Node<E> head;
    private int size;

    public CircularlyLinkedList(){
        size = 0;
        head = null;
    }

    public void add(E toAdd){
        // if head is null, then make a new node that loops to itself and add it to the list
        if( head == null){
            head = new Node<>(null, null, toAdd);
            head.previous = head;
            head.next = head;
        }
        // otherwise, insert it in front of the head, at the back of the loop
        else{
            Node<E> temp = new Node<>(head.previous, head, toAdd);
            head.previous.next = temp;
            head.previous = temp;
        }
        this.size++;
        // end
    }


    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return !( this.size > 0);
    }

    public void clear() {
        this.size = 0;
        this.head = null;
    }

    public E get() {
        if(size > 0) {
            return head.data;
        }
        else{
            return null;
        }
    }

    public E remove() {
        return null;
    }

}
