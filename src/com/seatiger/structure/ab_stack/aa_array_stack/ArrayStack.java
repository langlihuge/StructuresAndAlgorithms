package com.seatiger.structure.ab_stack.aa_array_stack;

import com.seatiger.structure.aa_array.ad_dynamic_array.Array;
import com.seatiger.structure.ab_stack.Stack;

/**
 * use the array implements stack
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
       this(10);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Stack: ");
        builder.append("[");
        for (int i = 0;i < array.getSize();i++){
            builder.append(array.get(i));
            if(i != array.getSize() -1){
                builder.append(",");
            }
        }
        builder.append("] top");
        return builder.toString();
    }
}
