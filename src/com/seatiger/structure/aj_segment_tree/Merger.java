package com.seatiger.structure.aj_segment_tree;

/**
 *
 * @param <E>
 */
public interface Merger<E> {
    E  merge(E a, E b);
}
