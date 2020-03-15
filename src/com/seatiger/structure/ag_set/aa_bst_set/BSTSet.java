package com.seatiger.structure.ag_set.aa_bst_set;

import com.seatiger.structure.af_binary_search_tree.BST;
import com.seatiger.structure.ag_set.FileOperation;
import com.seatiger.structure.ag_set.Set;

import java.util.ArrayList;

/**
 * use binary search tree implements set
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }


    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("pride-and-prejudice");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words);
        System.out.println("Total words: " + words.size());

        BST<String> set1 = new BST<>();
        for (String word: words ) {
            set1.add(word);
        }
        System.out.println("Total different words: " + set1.getSize());

        System.out.println();

        System.out.println("a-tale-of-two-cities");
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt",words2);
        System.out.println("Total words: " + words2.size());

        BST<String> set2 = new BST<>();
        for (String word: words2 ) {
            set2.add(word);
        }
        System.out.println("Total different words: " + set2.getSize());

    }

}
