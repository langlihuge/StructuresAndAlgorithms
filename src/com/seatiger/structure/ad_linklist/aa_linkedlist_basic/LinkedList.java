package com.seatiger.structure.ad_linklist.aa_linkedlist_basic;

/**
 * real dynamic data structures
 *
 * the data store in Node
 * class Node {
 *     E e
 *     Node next;
 * }
 *
 * +---+    +---+
 * | 1 |--->| 2 |--->null
 * +---+    +---+
 *
 * advantage: real dynamic data structures
 * disadvantage : lose the ability to do random access
 *
 */
public class LinkedList<E> {

    /**
     * (this.next = next) this very important
     * this sentences is the key to understands linked lists
     * the current node points to the next node,
     * becoming points to the node that passed by in user
     */
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }

    }

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    /**
     * get the numbers of the linked lists
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * determine the linked lists whether is empty
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * add a node at the first postion
     * the process can reference image/structure/ab_linkedList/aa_linkedlist_addFirst.jpg
     *
     * new Node(e,head);
     * this new node points to the head directly
     * @param e
     */
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        //can also use one sentence
        head = new Node(e,head);
        size++;
    }

    /**
     * adds to the {@index}specified position
     * first step:
     * so it is very important to find the previous position in a specified position
     *
     * second step:
     * let the new node point to specified position that is previous next,
     * new node().next = pre.next
     *
     * third step:
     * let the previous position points to new node
     * pre.next = new Node()
     *
     * it should be noted that if let previous position point to new Node()
     * and then let new node point previous next that is specified position
     * pre.next = new Node(); new Node().next = pre.next
     * that is error because pre.next is not specified, is new Node itself
     *
     * the process can reference image/structure/ad_linkedList/ab_linkedList_add.jpg
     *
     * @param e
     * @param index
     */
    public void add(E e,int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed,index is illegal");
        }
        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            for(int i = 0; i < index-1;i++){
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            //can also use one sentence
            prev.next = new Node(e,prev.next);
            size++;
        }
    }

    /**
     * add element int last position
     * @param e
     */
    public void addLast(E e){
        add(e,size);
    }




}
