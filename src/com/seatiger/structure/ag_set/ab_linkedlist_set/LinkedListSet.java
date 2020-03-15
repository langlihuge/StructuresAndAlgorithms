package com.seatiger.structure.ag_set.ab_linkedlist_set;

import com.seatiger.structure.ad_linklist.ab_linkedlist_dummyhead.LinkedList;
import com.seatiger.structure.ag_set.FileOperation;
import com.seatiger.structure.ag_set.Set;

import java.util.ArrayList;

/**
 * use linked list implements set
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet(){
        linkedList = new LinkedList<E>();
    }

    @Override
    public void add(E e) {
        if(linkedList.isContains(e)){
            return;
        }
        linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.isContains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("pride-and-prejudice");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words);
        System.out.println("Total words: " + words.size());

        LinkedListSet<String> set1 = new LinkedListSet<>();
        for (String word: words ) {
            set1.add(word);
        }
        System.out.println("Total different words: " + set1.getSize());

        System.out.println();

        System.out.println("a-tale-of-two-cities");
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt",words2);
        System.out.println("Total words: " + words2.size());

        LinkedListSet<String> set2 = new LinkedListSet<>();
        for (String word: words2 ) {
            set2.add(word);
        }
        System.out.println("Total different words: " + set2.getSize());
    }
}
