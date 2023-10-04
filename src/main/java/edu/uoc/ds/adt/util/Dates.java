package edu.uoc.ds.adt.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@MyAnotations(
        author = "Luis Fernandez Alvarez", date = "03/10/2023")

public class Dates {

    //Output format date
    public static final String OUT_PATTERN = "dd/MM";

    private LocalDate startDate;
    private short dateOffset;
    private long incrDate = 0;

    /**
     * Format a String date with patterm 'dd/MM/yyyy' a valid Localdate object
     *
     * @param date A valid string date. Must be in format 'dd/MM/yyyy'
     * @return A local date value
     * @throws DateTimeParseException If the String date cannot parse a valid local date
     */
    public static LocalDate format(String date) throws DateTimeParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    /**
     * From local date object format a String value
     *
     * @param date A LocalDate object
     * @return A String value
     */

    public static String format(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Dates.OUT_PATTERN);
        return formatter.format(date);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Set start date
     *
     * @param startDate A String value represents a date value
     */
    public void setStartDate(String startDate) {
        this.startDate = format(startDate);
    }

    /**
     * Get date offset
     *
     * @return a integer value
     */
    public short getDateOffset() {
        return dateOffset;
    }

    /**
     * Set a date offset
     *
     * @param dateOffset A integer value
     */
    public void setDateOffset(short dateOffset) {
        this.dateOffset = dateOffset;
        this.incrDate = dateOffset;
    }

    /**
     * Get the next date with offset from start date
     *
     * @return A local date object
     */
    public LocalDate nextOffsetDay() {
        LocalDate nextDate = startDate.plusDays(incrDate);
        incrDate += dateOffset;
        return nextDate;
    }

}
