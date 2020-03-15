package com.seatiger.structure.ah_map.ab_bst_map;

import com.seatiger.structure.af_binary_search_tree.BST;
import com.seatiger.structure.ag_set.FileOperation;
import com.seatiger.structure.ah_map.Map;

import java.util.ArrayList;

/**
 * use binary search tree implements map
 *
 * class Node{
 *  K k;
 *  V v;
 *  Node left;
 *  node right;
 * }
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key,V value){
           this.key = key;
           this.value = value;
           left = right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K k, V v) {
        root = add(k,v,root);
    }

    private Node add(K key,V value,Node node){
        if(node == null){
            size++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(key, value, node.left);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(key, value, node.right);
        }else {
            node.value = value;
        }
        return node;
    }

    private Node getNode(K key,Node node){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            return getNode(key, node.left);
        }else if(key.compareTo(node.key) > 0){
            return getNode(key,node.right);
        }else {
            return node;
        }
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k, root);
        if(node == null){
            throw new IllegalArgumentException(k + "is does'nt exit");
        }else {
            node.value = v;
        }

    }

    @Override
    public boolean contains(K k) {
        return getNode(k,root) == null ? false : true;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k, root);
        return node == null ? null : node.value;
    }

    @Override
    public V remove(K k) {
        Node node = getNode(k,root);
        if(node != null){
            root = remove(k,root);
            return node.value;
        }
        return null;
    }

    private Node remove(K key,Node node){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            node.left = remove(key,node.left);
            return node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(key,node.right);
            return node;
        }else {
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.left = node.left;
            successor.right =  removeMin(node.right);
            node.left = node.right = null;
            return successor;
        }
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node delNode = node.right;
            node.right = null;
            size--;
            return delNode;
        }
        node.left= removeMin(node.left);
        return  node;
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
