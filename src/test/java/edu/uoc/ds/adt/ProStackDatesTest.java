package edu.uoc.ds.adt;

import edu.uoc.ds.adt.util.Dates;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ProStackDatesTest {

    ProStackDates pr0q;

    private void fillStack() {

        if (pr0q.isEmpty())
            pr0q.push((Dates.format(pr0q.getStartDate())));

        for (int elem = 1; elem < pr0q.CAPACITY - 1; elem++) {
            pr0q.push(pr0q.getNextDate());
        }

    }

    @Before
    public void setUpStack() {

        final String START_DATE = "20/10/2023";
        final short DATE_OFFSET = 3;

        this.pr0q = new ProStackDates();

        try {
            //Set initial date
            this.pr0q.setStarDate(START_DATE);
            //Set date offset
            this.pr0q.setDateOffset(DATE_OFFSET);

            //Fill queue
            assertNotNull(this.pr0q.getStack());
            this.fillStack();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @After
    public void release() {
        this.pr0q = null;
    }

    @Test
    public void stackDatesTest() {

        StringBuffer sb = new StringBuffer();

        while (!pr0q.isEmpty()) {
            sb.append(pr0q.pop());
            if (!pr0q.isEmpty()) sb.append(",");
        }

        System.out.println(sb.toString());
    }
}
