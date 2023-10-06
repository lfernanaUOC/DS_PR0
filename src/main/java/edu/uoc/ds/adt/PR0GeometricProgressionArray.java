package edu.uoc.ds.adt;

import javax.swing.*;
import java.util.ArrayList;

public class PR0GeometricProgressionArray {

    private long[] vector;

    /**
     * Generates an array of geometric Progression (formula: <code>a_{n} = a_{1} \cdot r^{n-1}</code>
     * @param firstTerm
     * @param commonRatio
     * @param nTerms
     */
    public PR0GeometricProgressionArray(int firstTerm, int commonRatio, int nTerms){

        vector = new long[nTerms];

        for (int i=0;i<nTerms;i++){
            vector[i] = (long) (firstTerm * Math.pow(commonRatio,i));
        }
    }

    public long[] getArray(){
        return this.vector;
    }

    public String printArray(){

        if (vector!=null && vector.length>0){

            StringBuilder sb = new StringBuilder();

            for (int i=0;i<vector.length;i++) {
                sb.append(vector[i]);
                sb.append(" ");
            }

            return sb.toString();

        } else {
            return ""; // Return a blank string
        }

    }

    public int getIndexOf(long element){

        int index = -1; //By default, not found an return -1

        for (int i=0;i<vector.length;i++){
            if (element == vector[i]) {
                index = i; //found
                break;
            }
        }
        return index;
    }


    public int binarySearch(long element) {

        int index = -1; //If not found

        // Defines de first ,last and middle position of array
        int firstPos = 0;
        int lastPos = vector.length - 1;
        int midPos = (firstPos + lastPos) / 2;

        while (firstPos <= lastPos) {

            if (vector[midPos] < element)
                firstPos = midPos + 1;
            else {
                if (vector[midPos] == element)
                    return midPos;
                else
                    lastPos = midPos - 1;
            }

            midPos = (firstPos + lastPos) / 2;

        }
        return -1; //Not found
    }

}
