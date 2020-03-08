package com.seatiger.structure.ac_queue.ab_loop_queue;

import com.seatiger.structure.ac_queue.Queue;

/**
 * use array implements queue will has a problem that dequeue method
 * amortized time complexity is O(n)
 * so should use loop queue solve this problem
 *
 * use @front represents the position of the first element
 * and use @tail represents the last bit of the position of the last element
 *
 * the enqueue method and dequeue method process can
 * reference image/structure/ac_queue/ac_loopqueue_introduction.jpg
 *
 * in the loop will waste one position
 */
public class LoopQueue<E> implements Queue<E> {

    public E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    /**
     * ((tail + 1) % getCapacity() == front) show the loop queue is full
     * because will waste one position
     *
     * that the process can reference image/structure/ac_queue/ac_loopqueue_introduction.jpg
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    /**
     * that the process can reference image/structure/ac_queue/ac_loopqueue_introduction.jpg
     * @return
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("dequeue is failed.Loop queue is empty");
        }
        E e = data[front];
        front = (front + 1) % data.length;
        size--;
        if(size <= getCapacity() / 4 && getCapacity() != 0){
            resize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("getFront is failed.Loop queue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * (tail == front) show the loop queue is empty
     * @return
     */
    @Override
    public boolean isEmpty() {
        return tail == front;
    }


    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity+1];
        int j = 0;
        for(; front != tail; front = (front+ 1) % data.length){
            newData[j++] = data[front];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        builder.append("front [");
        for(int i =0 ; i < size;i++){
            builder.append(data[(i + front) % data.length]);
            if(i != size - 1){
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>();

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
