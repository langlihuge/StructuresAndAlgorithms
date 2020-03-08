package com.seatiger.structure.af_binary_search_tree;

import java.util.*;

/**
 * before introduce the binary search tree.you should know something
 * about binary tree
 *
 *
 * binary tree like node is dynamic data structure
 * the basic mode
 * class Node{
 *     E e;
 *     Node left;
 *     Node right
 * }
 *
 * the binary tree has only root node
 * each node has a maximum of two children
 * each node has a maximum of one father
 *
 * the binary tree recursive structure naturally
 * each node's left child is also binary tree
 * each node's right child is also binary tree
 *
 * binary tree no always full
 * event none node is also binary tree
 *
 * the introduce can reference image/structure/af_binary_search_tree/aa_introduce_binary_tree.jpg
 *
 * let to introduce the binary search tree
 * the binary search tree is binary tree
 * this each node element should greater than this left node tree all element
 * and this each node element should less than this right node tree all element
 * so the element should be comparability
 *
 * each child node is also binary search tree
 *
 * the introduce can reference
 * image/structure/af_binary_search_tree/ab_introduce_binary_search_tree.jpg
 */
public class BST<E extends Comparable<E>> {

    /**
     * create the basic node
     */
    private class Node{
        E e;
        Node left;
        Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    /**
     * get the numbers of the bst
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * determine the bst whether is empty
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * add an element in bst
     * @param e
     */
    public void add(E e){
//        if(root == null){
//            size++;
//            root = new Node(e);
//        }else{
//            add(root,e);
//        }
        root = add2(root,e);
    }

    /**
     * add an element in bat that root node is @{node}
     * if this element less than this node's element,should add left
     * and then continue judge this element and left's element
     * if greater than ,should  add right
     * and then continue judge
     *
     * attention thar this bst don't contain duplicate element
     *
     * this is recursion process can reference  image/structure/af_binary_search_tree/ac_process_add.jpg
     * @param node
     * @param e
     */
    private void add(Node node,E e){

        if(e.compareTo(node.e) == 0){
            return;
        }else if(e.compareTo(node.e) < 0){
            if(node.left == null){
                node.left = new Node(e);
                size++;
                return;
            }
            add(node.left,e);
        } else if (e.compareTo(node.e) > 0){
            if(node.right == null){
                node.right = new Node(e);
                size++;
                return;
            }
            add(node.right,e);
        }
    }

    /**
     * this method fucntion is the same as add
     * return root node that after add element
     * @param node
     * @param e
     * @return
     */
    private Node add2(Node node,E e){

        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add2(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add2(node.right,e);
        }

        return node;


    }

    /**
     * determine whether this bst haa element
     * @param e
     * @return
     */
    public boolean contains(E e){
        
       return contains(root,e);
    }

    /**
     * look up this bst that the root is node whether has element,
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else if(e.compareTo(node.e) > 0){
           return  contains(node.right,e);
        }else{
            return true;
        }
    }

    /**
     * the bst traversal can reference image/structure/af_binary_search_tree/ad_bst_traversal.jpg
     */

    /**
     * preorder traversal
     * first visit root node ,second visit left node and last visit right node
     */
    public void perOrder(){
        perOrder(root);
    }

    private void perOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.e + " ");
        perOrder(node.left);
        perOrder(node.right);
    }


    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");
    }

    /**
     * inorder traversal
     * first left node,second root node,last right
     * this result is sequential
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * Subsequent traversal
     * first left node,second right node,last root node
     * @param node
     */
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }

    /**
     * preorder traversal,but not use recursion,use stack
     * the process can reference image/structure/af_binary_search_tree/ae_perOrderNR.jpg
     */
    public void perOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            Node node = stack.pop();
            System.out.print(node.e + " ");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    /**
     * the process can reference image/structure/af_binary_search_tree/af__levelOrder.jpg
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(node.e + " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

        }
    }


    /**
     * get the smallest element
     * @return
     */
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is Empty");
        }
        return minimum(root).e;
    }

    /**
     * return node that the smallest element in the node
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }


    /**
     * get the largest element
     * @return
     */
    public E maximum(){
        return maximum(root).e;
    }

    /**
     * return node that the largest element in the node
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    /**
     * remove the smallest element
     * return the element be removed
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * remove the smallest element that this root is node
     * return new node that after remove
     *
     * the process can reference image/structure/af_binary_search_tree/ag_removeMin.jpg
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * remove the largest element
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * remove node from bst where element is e
     * @param e
     */
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * remove node that the bst's root is @{node}
     * return new root node after remove
     *
     * if the removed node only has left node or only has right node
     * can reference the removeMin() method and removeMax() method
     * the process can reference image/structure/af_binary_search_tree/ah_removeNode1.jpg
     *
     * if the removed node has left node and has right node
     * can first find minimum node that in removed node's right
     * so call this node successor, the successor replace removed node
     *
     * the process can reference image/structure/af_binary_search_tree/ai_removeNode2.jpg
     *
     * @param node
     * @param e
     * @return
     */
    public Node remove(Node node,E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
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

            //find successor that in removed node's right that is smallest element
            //let this successor node point to removed node's left
            Node successor = minimum(node.right);
            successor.left = node.left;
            successor.right = removeMin(node.right);
            node.left = node.right = null;
            return successor;

        }

    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node,int depth,StringBuilder builder){
        if(node == null){
            builder.append(generateDepthString(depth) + "null\n");
            return;
        }

        builder.append(generateDepthString(depth++) +node.e+ "\n");
        generateBSTString(node.left,depth,builder);
        generateBSTString(node.right,depth,builder);
    }

    private String generateDepthString(int depth){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < depth;i++){
            builder.append("--");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int nums[] = {5,3,7,6,8,4,2,9};
        for(int i = 0; i < nums.length;i++){
            bst.add(nums[i]);
        }
        /////////////////
        //      5      //
        //    /   \    //
        //   3    7    //
        //  / \  / \   //
        // 2  4 6   8  //
        //           \ //
        //            9//
        /////////////////
        bst.perOrder();//53247689
        System.out.println("\n-----------");
        bst.perOrderNR();
        System.out.println("\n-----------");
        System.out.println(bst.toString());

        bst.inOrder();//23456789
        System.out.println("\n-----------");
        bst.postOrder();//24369875
        System.out.println("\n-----------");
        bst.levelOrder();
        System.out.println();

        testRemoveMin();

        testRemoveMax();

    }

    public static void testRemoveMin(){
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;

        // test removeMin
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println(bst.getSize());
        while(!bst.isEmpty())
            nums.add(bst.removeMin());

        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++)
            if(nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMin test completed.");
    }

    public static void testRemoveMax(){
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        ArrayList<Integer> nums = new ArrayList<>();

        int n = 1000;
        // test removeMax
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        nums = new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMax());

        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++)
            if(nums.get(i - 1) < nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMax test completed.");    }
}
