package edu.uoc.ds.adt;

public @interface MyAnotations {

    String author();

    String date();

    int currentRevision() default 1;

}
