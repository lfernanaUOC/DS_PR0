package edu.uoc.ds.adt.util;

public @interface MyAnotations {

    String author();

    String date();

    int currentRevision() default 1;
}
