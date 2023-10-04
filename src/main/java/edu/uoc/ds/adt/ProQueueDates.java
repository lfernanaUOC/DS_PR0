package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;
import edu.uoc.ds.adt.util.Dates;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * A class management a collection of 10 string dates using a queue
 * The first element is a start date and the rest of elements are
 * string dates with a interval especified by offset
 *
 * @Autor: Luis Fernandez Alvarez
 */

public class ProQueueDates extends Data implements IProQueue<String> {


    private Queue<String> queue;

    public ProQueueDates() {
        dates = new Dates();
        newQueue();
    }

    public ProQueueDates(String startDate, short offset) throws Exception {

        dates = new Dates();

        try {

            dates.setStartDate(startDate);
            this.dateOffset = offset;

            newQueue();

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
    public Queue<String> getQueue() {
        return this.queue;
    }

    @Override
    public void add(String s) {

        this.queue.add(s);
    }

    /**
     * Check if the current queue is empty
     *
     * @return A boolean value
     */
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    /**
     * Get next date
     *
     * @return A String value
     */
    public String getNextDate() {
        return Dates.format(dates.nextOffsetDay());
    }

    public String poll() {
        return this.queue.poll();
    }
}
