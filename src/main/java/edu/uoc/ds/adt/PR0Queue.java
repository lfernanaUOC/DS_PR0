package edu.uoc.ds.adt;


import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

public class PR0Queue implements IProQueue<Character> {

    public final int CAPACITY = 10;

    private Queue<Character> queue;

    public PR0Queue() {
        newQueue();
    }

    public void newQueue() {
        queue = new QueueArrayImpl<>(CAPACITY);
    }


    @Override
    public String clearFullQueue() {
        StringBuilder sb = new StringBuilder();
        char r;
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public Queue<Character> getQueue() {
        return this.queue;
    }

    @Override
    public void add(Character c) {
        this.queue.add(c);
    }
}
