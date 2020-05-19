package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private PriorityQueue<Integer> largestNumbers;

    public KthLargest(int k, int[] numbers) {
        largestNumbers = new PriorityQueue<Integer>();
        for (int i = 0; i < k; ++i) {
            largestNumbers.add(-1);
        }
        for (int i = 0; i < numbers.length; ++i) {
            this.add(numbers[i]);
        }

    }

    private int first() {
        return largestNumbers.iterator().next();
    }

    public int add(int val) {
        if (first() > val) {
            return first();
        }
        largestNumbers.remove(first());
        System.out.println("add " + val);
        return first();
    }
}