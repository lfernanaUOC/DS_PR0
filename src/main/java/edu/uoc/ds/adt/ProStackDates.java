package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;
import edu.uoc.ds.adt.util.Dates;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * A class management a collection of 10 string dates using a stack
 * The first element is a start date and the rest of elements are
 * string dates with a interval especified by offset
 *
 * @Autor: Luis Fernandez Alvarez
 */
public class ProStackDates extends Data implements IProStack<String> {

    private Stack<String> stack;

    ProStackDates() {
        dates = new Dates();
        newStack();
    }

    public ProStackDates(String startDate, short offset) throws Exception {

        dates = new Dates();

        try {

            dates.setStartDate(startDate);
            this.dateOffset = offset;

            newStack();

        } catch (DateTimeParseException e) {
            throw new Exception("ERROR: start date value is not valid");
        }


    }


    /**
     * Set the start date
     *
     * @param startDate A valid string value of date
     * @throws Exception Retrun an error message for invalid date
     */
    public void setStarDate(String startDate) throws Exception {

        if (dates != null) {

            try {

                dates.setStartDate(startDate);

            } catch (DateTimeParseException e) {
                throw new Exception("ERROR: start date value is not valid");
            }
        }
    }

    /**
     * Get the current start date
     *
     * @return A local date object represents the current date
     */
    public LocalDate getStartDate() {
        return dates.getStartDate();
    }

    /**
     * Set date offset
     *
     * @param dateOffset A integer value
     */
    public void setDateOffset(short dateOffset) {
        this.dates.setDateOffset(dateOffset);
    }

    /**
     * Check if the current queue is empty
     *
     * @return A boolean value
     */
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * Get next date
     *
     * @return A String value
     */
    public String getNextDate() {
        return Dates.format(dates.nextOffsetDay());
    }

    public void newStack() {
        stack = new StackArrayImpl<String>(CAPACITY);
    }

    @Override
    public String clearAllStack() {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop()).append(" ");
        return sb.toString();
    }

    @Override
    public Stack<String> getStack() {
        return this.stack;
    }


    @Override
    public void push(String elem) {
        this.stack.push(elem);
    }

    public String pop() {
        return stack.pop();
    }
}
