package edu.uoc.ds.adt;


import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;

public class PR0Stack implements IProStack<Character> {
    public final int CAPACITY = 10;

    private Stack<Character> stack;

    public PR0Stack() {
        newStack();
    }

    public void newStack() {
        stack = new StackArrayImpl<Character>(CAPACITY);
    }


    @Override
    public String clearAllStack() {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop()).append(" ");
        return sb.toString();
    }

    @Override
    public Stack<Character> getStack() {
        return this.stack;
    }

    @Override
    public void push(Character c) {
        this.stack.push(c);
    }
}
