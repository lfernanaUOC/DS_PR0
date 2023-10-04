package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Stack;

public interface IProStack<T> {

    /**
     * Clear the stack
     *
     * @return A String blank value
     */
    String clearAllStack();

    /**
     * Return the current stack
     *
     * @return A Stack object
     */
    Stack<T> getStack();

    /**
     * Push a elem in a stack
     *
     * @param elem A elemnent to push in the stack
     */
    public void push(T elem);
}
