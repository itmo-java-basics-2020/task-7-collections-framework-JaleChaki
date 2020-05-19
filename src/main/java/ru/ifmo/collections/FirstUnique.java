package ru.ifmo.collections;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private ArrayList<Integer> singleValuesContainer;

    private HashSet<Integer> multiValuesContainer;

    public FirstUnique(int[] numbers) {
        singleValuesContainer = new ArrayList<Integer>();
        multiValuesContainer = new HashSet<Integer>();
        if (numbers != null) {
            for (int i = 0; i < numbers.length; ++i) {
                this.add(numbers[i]);
            }
        }
    }

    public int showFirstUnique() {
        if (singleValuesContainer.isEmpty()) {
            return -1;
        }
        return singleValuesContainer.get(0);
    }

    public void add(int value) {
        if (multiValuesContainer.contains(value)) {
            return;
        }
        if (singleValuesContainer.contains(value)) {
            singleValuesContainer.remove(Integer.valueOf(value));
            multiValuesContainer.add(value);
        } else {
            singleValuesContainer.add(value);
        }
    }
}
