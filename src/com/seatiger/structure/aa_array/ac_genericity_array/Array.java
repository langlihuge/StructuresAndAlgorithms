package com.seatiger.structure.aa_array.ac_genericity_array;

/**
 * use genericity
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * constructs array with capacity
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
    }

    /**
     * no-args construct, the default array capacity is 10
     */
    public Array(){
        this(10);
    }

    /**
     * return the number of elements in the array
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * return the capacity of elements in the array
     * @return
     */
    public int getCapaCity(){
        return data.length;
    }

    /**
     * determine that the array is empty
     * if the array is empty return true
     * else return false
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * add an element to the end of array
     * because the {@size } variate points to array that the first position
     * with out element
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * add an element at the designated position
     * the process can reference the image/aa_array/aa_array_add.jpg
     * @param index
     * @param e
     */
    public void add(int index, E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <=size");
        }

        if(size == data.length){
            throw new IllegalArgumentException("Add failed. Array is full");
        }

        for(int i = size; i > index;i--){
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    /**
     * add an element to the first position
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * get an element at the index location
     * this method ensure the security of the data
     * because the user can only get data that is already
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >=size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * change the index location element
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index >=size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * estimate whether the array contains element
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0;i<size;i++){
            if (data[i].equals(e) ){
                return true;
            }
        }
        return false;
    }

    /**
     * find the location index for element
     * if find return index
     * if not find return -1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0;i<size;i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * delete the index of location
     * return the index of location element
     * the process can reference the image/aa_array/ab_array_remove.jpg
     * @param index
     * return
     */
    public E  remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        E result = data[index];
        for(int i = index; i< size-1; i++){
            data[i] = data[i+1];
        }
        size--;
        return result;
    }

    /**
     * remove the first element
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * remove the last of element
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * delete the specified element form array
     * if the array has multiple identical element
     * only remove the first one
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size= %d, capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size;i++){
            res.append(data[i]);
            if(i != size -1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }


}
