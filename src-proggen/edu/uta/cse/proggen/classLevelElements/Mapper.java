package edu.uta.cse.proggen.classLevelElements;

/**
 * Created by Aditya on 029, 29 Apr, 2017.
 */
public class Mapper {
    private String element;
    private int numberOfElements;

    public Mapper(String element, int numberOfElements) {
        this.element = element;
        this.numberOfElements = numberOfElements;
    }

    public String getElement() {
        return element;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }
}
