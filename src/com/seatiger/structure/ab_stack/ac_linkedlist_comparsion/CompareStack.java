package com.seatiger.structure.ab_stack.ac_linkedlist_comparsion;

import com.seatiger.structure.ab_stack.Stack;
import com.seatiger.structure.ab_stack.aa_array_stack.ArrayStack;
import com.seatiger.structure.ab_stack.ab_linkedList_stack.LinkedListStack;
import com.seatiger.structure.ac_queue.ac_linkedlist_queue.LinkedListQueue;

import java.util.Random;

/**
 * test the performance of various stack
 *
 * This time is actually more complicated
 * because the LinkedListStack contains more new operations
 *
 */
public class CompareStack {
    private static double testStack(Stack<Integer> stack, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 500000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");


    }
}
