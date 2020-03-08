package com.seatiger.structure.ab_stack;

/**
 * the stack is also a liner structure
 * stack corresponds to an operation that is a subset of an array,
 * as opposed to an array
 * elements can only be added from th outside, and element can only
 * be taken form the outside
 * this side is called the top of the stack
 *
 * the stack is a last in, first out data structure
 *
 * the process can reference image/structure/ab_stack/aa_stack_introduction
 *
 */
public interface Stack<E> {

    /**
     * put the element at the top of the stack
     * @param e
     */
    void push(E e);

    /**
     * take the element from the top of the stack
     * @return
     */
    E pop();

    /**
     * look up the element from the top of the stack
     * @return
     */
    E peek();

    /**
     * get the numbers of statck
     * @return
     */
    int getSize();

    /**
     * determine if the stack is empty
     * @return
     */
    boolean isEmpty();

}
