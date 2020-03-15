package com.seatiger.structure.ag_set;

/**
 * the structure don'nt have the same elements
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
