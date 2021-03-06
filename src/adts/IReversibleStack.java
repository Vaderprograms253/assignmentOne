package adts;

import java.util.Iterator;

/**
 * Represents a FILO Stack structure that can reverse
 * the order of elements in the stack.
 *
 * DO NOT EDIT THIS FILE!
 *
 * @param <T> the type of elements in the stack
 *
 * @author Josh Archer
 * @version 1.0
 */
public interface IReversibleStack<T> extends ICollection<T>
{
    /**
     * Reverses the order of all elements in the stack.
     * For example: (bottom) a, b, c, d (top) becomes
     *              (bottom) d, c, b, a (top) after
     *              calling reverse()
     */
    void reverse();

    /**
     * Removes, and returns, the top element of the stack.
     * @return the top element of the stack
     * @throws java.util.NoSuchElementException when the stack is empty
     */
    T remove();

    /**
     * Returns elements in FILO order from the underlying stack
     * @return all elements in the stack, in FILO order
     */
    @Override
    Iterator<T> iterator();
}
