package com.seatiger.structure.ac_queue.ad_queues_comparsion;

import com.seatiger.structure.ac_queue.Queue;
import com.seatiger.structure.ac_queue.aa_array_queue.ArrayQueue;
import com.seatiger.structure.ac_queue.ab_loop_queue.LoopQueue;
import com.seatiger.structure.ac_queue.ac_linkedlist_queue.LinkedListQueue;

import java.util.Random;

/**
 *  test the performance of various queues
 */
public class CompareQueues {
    private static double testQueue(Queue<Integer> queue, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0;i < opCount;i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount;i++){
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");
    }
}
