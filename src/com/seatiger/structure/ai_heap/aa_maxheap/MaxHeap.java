package com.seatiger.structure.ai_heap.aa_maxheap;

import com.seatiger.structure.aa_array.ad_dynamic_array.Array;

/**
 * the basic  structure of the heap
 * the heap is complete binary tree that arrange the elements
 * in order to from the shape of the tree
 *
 * the biggest heap that the value of a node in the heap is
 * always no greater than the value  its parents node
 *
 * on the basis cf heap's character ,can use array store heap
 * so one node that index is i, can calculate parent's node index is (i -1 )/2,
 * left child node is (2 * i) + 1,right child node is (2 * i) + 2
 *
 * can reference the image/structure/ai_heap/aa_the_basic_heap.jpg
 */
public class MaxHeap<E extends Comparable<E>> {

    //use array show heap
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    /**
     * sort arbitrary arrays into heap
     * can find the first not leaf node and from this node execute siftDown
     * @param arr
     */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(data.getSize()-1);i>=0;i--){
            siftDown(i);
        }
    }

    /**
     * get the size of heap
     * @return
     */
    public int size(){
        return data.getSize();
    }

    /**
     * estime whether the heap is empty
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * return the index show the element that parent node's index
     * in use array show the compete binary heap
     * @param index
     * @return
     */
    private int parent(int index){
        if(index <= 0)
            throw new IllegalArgumentException("index-0 doesn't hava parents");
        return (index - 1) /2;
    }

    /**
     * return the index show the element that left child node's index
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * return the index show the element that right child node's index
     * @param index
     * @return
     */
    private int rightChilde(int index){
        return index * 2 + 2;
    }

    /**
     * add a element into heap
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * when add last in array, so should keep the character of the max heap
     * the new element node can not greater than this parent's node element
     * if greater,should change seats. after change, should always compare the
     * new parent's node elements.if not satisfied character,we should also
     * change once satisfied character
     *
     * the process can reference image/structure/ai_heap/ab_siftUp.jpg
     *
     * @param index
     */
    private void siftUp(int index){
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0){
            data.swap(index,parent(index));
            index = parent(index);
        }
    }

    /**
     * find the max element in the heap
     * @return
     */
    public E findMax(){
        if(data.isEmpty()){
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.getFirst();
    }

    /**
     * take out the max element in the heap
     * because the max element in the first position,
     * so can swap first and last element,and remove the last element
     * after we should keep the character of the heap,so can siftDown()
     * @return
     */
    public E extractMax(){
        E e = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return e;
    }

    /**
     * can compare the {@index} position node with leftChild and rightChild
     * choose the greater one change with @index position
     * after we should continue compare in the new @index position until the @index
     * position element greater than the leftChild and rightChild
     *
     * the process can reference image/structure/ai_heap/ac_siftDown.jpg
     * @param index
     */
    private void siftDown(int index){
        //should insure leftChild index less than size - 1
        while(leftChild(index) < data.getSize()){
            int j = leftChild(index);
            //insure have right child
            //so data[j] is biggest in the leftChild and rightChild
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChilde(index);
            }

            if(data.get(index).compareTo(data.get(j)) < 0){
                data.swap(index,j);
                index = j;
            }else{
                break;
            }
        }
    }

    /**
     * take out the max element and replace it with e
     * @param e
     * @return
     */
    public E replace(E e){
        E retE = findMax();
        data.set(0,e);
        siftDown(0);
        return  retE;
    }


}
