package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;

public interface IProQueue<T> {


    /**
     * Clear current Queue object
     *
     * @return A empty string value
     */
    public String clearFullQueue();

    /**
     * Return the queue object
     *
     * @return A current Queue object
     */
    public Queue<T> getQueue();

    /**
     * Add an item to the queue, if any.
     *
     * @param element item to add to the queue
     */
    public void add(T element);
}
