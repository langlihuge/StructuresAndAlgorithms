package com.seatiger.structure.ac_queue;

/**
 * queue is also a liner structure
 * queue corresponds to an operation that is a subset of an array,
 * as opposed to an array
 *
 * elements can be added form the end of queue
 * elements can be taken form the top of queue
 *
 * the statck is first in,first out data structure
 *
 * the process can reference the image/structure/aa_queue/aa_queue_introduction
 * @param <E>
 */
public interface Queue<E> {

    /**
     * first in
     * @param e
     */
    void enqueue(E e);

    /**
     * first out
     * @return
     */
    E dequeue();

    /**
     * look up first element
     * @return
     */
    E getFront();

    /**
     * get the numbers of queue
     * @return
     */
    int getSize();

    /**
     * determine the queue whether the queue has elements
     * @return
     */
    boolean isEmpty();
}
