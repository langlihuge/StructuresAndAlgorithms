package com.seatiger.structure.ac_queue.aa_array_queue;

import com.seatiger.structure.aa_array.ad_dynamic_array.Array;
import com.seatiger.structure.ac_queue.Queue;

/**
 * use array implements queue
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        this(10);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapaCity();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Queue: ");
        builder.append("front [");
        for (int i =0;i < array.getSize();i++){
            builder.append(array.get(i));
            if(i != array.getSize() - 1){
                builder.append(",");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
