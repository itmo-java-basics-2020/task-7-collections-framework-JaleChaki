package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public abstract class SortedSet<T> extends AbstractSet<T> {
    // private final Map<???, ???> contents; TODO decide Map implementation and key/value types. "???" is used just as an example
    public static <T> SortedSet<T> create() {
        return new ConcreteSortedSet<T>(null);
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new ConcreteSortedSet<T>(comparator);
    }

    public ArrayList<T> getSorted() {
        throw new UnsupportedOperationException(); // TODO implement
    }

    public ArrayList<T> getReversed() {
        throw new UnsupportedOperationException(); // TODO implement
    }

    private static class ConcreteSortedSet<T> extends SortedSet<T> {

        TreeMap<T, Object> innerCollection;

        private Object crutch;

        public ConcreteSortedSet(Comparator<T> cmp) {
            innerCollection = new TreeMap<>(cmp);
            crutch = new Object();
        }

        @Override
        public ArrayList<T> getReversed() {
            return new ArrayList<T>(innerCollection.descendingKeySet());
        }

        @Override
        public ArrayList<T> getSorted() {
            return new ArrayList<T>(innerCollection.keySet());
        }

        @Override
        public boolean add(T obj) {
            return innerCollection.put(obj, crutch) == null;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            boolean result = false;
            for (T obj : c) {
                result = this.add(obj) || result;
            }
            return result;
        }

        @Override
        public boolean remove(Object obj) {
            return innerCollection.remove(obj) != null;
        }

        @Override
        public Iterator<T> iterator() {
            return innerCollection.keySet().iterator();
        }

        @Override
        public int size() {
            return innerCollection.size();
        }
    }
}
