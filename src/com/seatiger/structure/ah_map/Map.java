package com.seatiger.structure.ah_map;

/**
 * find value by key
 */
public interface Map<K,V> {

    void add(K k,V v);

    V remove(K k);

    boolean contains(K k);

    V get(K k);

    void set(K k, V v);

    int getSize();

    boolean isEmpty();
}
