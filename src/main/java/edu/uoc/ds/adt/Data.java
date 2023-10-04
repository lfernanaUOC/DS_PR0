package edu.uoc.ds.adt;

import edu.uoc.ds.adt.util.Dates;

/**
 * An abstract class for store application data
 */
public abstract class Data {

    public final int CAPACITY = 10;

    public Dates dates = null;
    public short dateOffset = 1; //By default offset date value is 1


}
