package edu.uoc.ds.adt;

import edu.uoc.ds.adt.util.Dates;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ProQueueDatesTest {

    ProQueueDates pr0q;

    /**
     * Fill queue of 10 elements. Each element contains a string date as a "dd/MM/yyyy" format.
     * Teh fisrt element is a start date and the rest of them area sequence of string date with determined offset
     * Por example:
     * If start date is '10/10/2023' and offset=2, the next sequence are:
     * 12/10/2023, 14/10/2023 ... until 30/10/2023
     */
    private void fillQueue() {
        if (pr0q.isEmpty())
            pr0q.add(Dates.format(pr0q.getStartDate()));

        for (int elem = 1; elem < pr0q.CAPACITY - 1; elem++) {
            pr0q.add(pr0q.getNextDate());
        }

    }

    /**
     *
     */
    @Before
    public void setupQueue() {

        final String START_DATE = "20/10/2023";
        final short DATE_OFFSET = 3;

        this.pr0q = new ProQueueDates();

        try {
            //Set initial date
            this.pr0q.setStarDate(START_DATE);
            //Set date offset
            this.pr0q.setDateOffset(DATE_OFFSET);

            //Fill queue
            assertNotNull(this.pr0q.getQueue());
            fillQueue();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @After
    public void releaseQueue() {
        this.pr0q = null;
    }

    @Test
    public void queueDatesTest() {

        StringBuffer sb = new StringBuffer();

        while (!pr0q.isEmpty()) {
            sb.append(pr0q.poll());
            if (!pr0q.isEmpty()) sb.append(",");
        }

        System.out.println(sb.toString());
    }
}
