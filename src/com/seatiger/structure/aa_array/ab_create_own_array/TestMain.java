package com.seatiger.structure.aa_array.ab_create_own_array;

/**
 * used for test
 */
public class TestMain {
    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i<10;i++){
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1,100);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(8);
        System.out.println(array);
    }
}
