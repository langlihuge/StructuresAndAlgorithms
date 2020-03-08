package com.seatiger.structure.ad_linklist.ab_linkedlist_dummyhead;

/**
 * because add method and addFirst that we should deal with separately
 *
 * so we can use dummy head to solve this problem
 * the dummy head node do'nt have element
 *
 * +---+     +---+    +---+
 * |null|--->| 1 |--->| 2 |--->null
 * +---+     +---+    +---+
 *   |
 *   |
 * dummy head
 *
 * so every node has previous node
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

    private Node dummyhead;
    private int size;

    /**
     * dummyhead has node when initialize
     */
    public LinkedList(){
        dummyhead = new Node();
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
     *add element in first position
     * @param e
     */
    public void addFirst(E e){
        add(e,0);
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
     * because have dummy head so every node has previous position
     *
     * @param e
     * @param index
     */
    public void add(E e,int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed,index is illegal");
        }

            Node prev = dummyhead;
            for(int i = 0; i < index;i++){
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            //can also use one sentence
            prev.next = new Node(e,prev.next);
            size++;

    }

    /**
     * add element in last position
     * @param e
     */
    public void addLast(E e){
        add(e,size);
    }

    /**
     * get element at the {@index} position
     *
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed,index is illegal");
        }
        Node cur = dummyhead.next;
        for(int i =0; i < index;i++){
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * get the first element
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * get the last element
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * update the {@index} position element to e
     *
     * can find cur position
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed,index is illegal");
        }

        Node cur = dummyhead.next;
        for(int i = 0; i < index;i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * determine the linked list whether has element e
     * @return e
     */
    public boolean isContains(E e){
//        Node cur = dummyhead;
//        for(int i = 0; i < size - 1;i++){
//            if(cur.next.e.equals(e)){
//                return true;
//            }
//        }
//        return false;
        Node cur = dummyhead.next;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    /**
     * delete the {@index} specified position element
     *
     * first step:
     * find the previous position in a specified that is delNode
     *
     * second step:
     * let the previous position point to delNode's next
     * pre.next = delNode.next
     *
     * third step:
     * let delNode point to null that can facilitate recycling
     * delNode.next = null
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed,index is illegal");
        }

        Node prev = dummyhead;
        ;
        for(int i = 0 ; i < index;i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        Node cur = dummyhead.next;
        while (cur != null){
            builder.append(cur + "-->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(666, 2);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);
    }

}
