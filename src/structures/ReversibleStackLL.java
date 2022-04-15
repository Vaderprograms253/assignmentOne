package structures;

import adts.IReversibleStack;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @param <T>
 * @author Xavier Denson
 * @version 17
 * This class defines a stack that can have its elements reversed
 */
public class ReversibleStackLL<T> implements IReversibleStack<T> {

    private Node head;
    private Node tail;

    private class Node{

        private T data;
        private Node next;
        private Node prev;

        //constructor to pass in data
        public Node(T data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node data:" +
                    "data=" + data +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }


    /**
     * Adds an element to the collection.
     *
     * @param element the element to add
     */
    @Override
    public void add(T element) {
        Node addNode = new Node(element);
        //if collection is empty
        if (head == null){
            head = addNode;
            tail = addNode;
            head.prev = null;
        } else {
           tail.next = addNode;
           addNode.prev = tail;
           tail = addNode;
        }
        tail.next = null;
    }

    /**
     * Searches for and removes the first occurrence of an element
     * from the collection.
     * this method is not supported in the structure
     * @param element the element to search for
     * @throws NoSuchElementException if the element
     *                                is not found
     */
    @Override
    public void remove(T element) throws UnsupportedOperationException {

    }

    /**
     * Returns true if the element is located in the collection,
     * or otherwise false.
     *
     *
     * @param element the element to search for
     * @return true if the element is found, otherwise false
     */
    @Override
    public boolean contains(T element) {
        boolean containsNode = false;

       Node current = head;
       if(head == null){
         return false;
       }
       //exit loop if element is found
       while (current != null){
           if (current.data == element) {
               containsNode = true;
               break;
           }
           current = current.next;
       }
        return containsNode;
    }

    /**
     * Returns the number of elements in the collection.
     *
     * @return the element count
     */
    @Override
    public int size() {
        int length = 0;
        if (head == null) {
            return length;
        }
            Node current = this.head;

            while (current != null){
                length += 1;
                current = current.next;
            }
            return length;
    }

    /**
     * Returns true if the collection is empty, or otherwise false
     *
     * @return true if the collection is empty, or otherwise false
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Removes all elements from the collection.
     */
    @Override
    public void clear() {
        //change the head to next until collection is empty
        while (head != null){
            this.head = this.head.next;
        }
    }

    /**
     * Reverses the order of all elements in the stack.
     * For example: (bottom) a, b, c, d (top) becomes
     * (bottom) d, c, b, a (top) after
     * calling reverse()
     */
    @Override
    public void reverse() {
        //create temp holder
        Node temp = null;
        Node current = head;

        //change next to previous and previous to next
        //swap head and tail outside of loop
        while (current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null){
            tail = head;
            head = temp.prev;
        }

    }

    /**
     * Removes, and returns, the top element of the stack.
     *
     * @return the top element of the stack
     * @throws NoSuchElementException when the stack is empty
     */
    @Override
    public T remove() {
        if (head == null){
            throw new NoSuchElementException("No elements in stack");
        }
        Node temp = head;
        head = head.next;
        return temp.data;
    }

    /**
     * Returns elements in FILO order from the underlying stack
     * Will be implemented in part two
     * @return all elements in the stack, in FILO order
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }


    @Override
    public String toString() {
        if (head == null){
            return " ";
        }
        StringBuilder listString = new StringBuilder();
        Node current = head;
        while (current.next != null){
            listString.append(current.data);
            current = current.next;
            if (current.next != null){
                listString.append(" ");
            }

        }
        listString.append(" ").append(tail.data);
        return listString.toString();
    }
}
