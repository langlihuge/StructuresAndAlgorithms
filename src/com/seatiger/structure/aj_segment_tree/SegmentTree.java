package com.seatiger.structure.aj_segment_tree;

/**
 * what is segment tree,for example,in an array
 * if you find the sum of a segment of the array
 *
 * you can create structure to store the sum that every segment of  array
 * the introduction can reference the image/structure/aj_segment_tree/aa_introductionOfSegmentTree.jpg
 *
 * here use an array that represent a complete binary tree to create an segment tree
 *
 */
public class SegmentTree<E> {

    private E[] tree;
    private E[] data;

    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){


        this.data = (E[])new Object[arr.length];
        this.merger = merger;

        for(int i = 0; i < arr.length;i++){
            data[i] = arr[i];
        }

        //define a segment tree
        this.tree = (E[]) new Object[arr.length * 4];


        buildSegmentTree(0,0,arr.length-1);
    }

    /**
     * create a line segment tree that represents the interval[l, r] in the
     * position of the treeIndex
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex,int l, int r){
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rigthTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l)/2;

        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rigthTreeIndex,mid + 1,r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rigthTreeIndex]);
    }


    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 && index > data.length - 1){
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    /**
     * return an index that this {@index} represent the left child node element
     * in the complete binary tree
     * @param index
     * @return
     */
    private int leftChild(int index){
        return 2* index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    public E query(int queryL,int queryR){
        if(queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
        throw new IllegalArgumentException("Index is illegal.");

        return query(0,0,data.length - 1,queryL,queryR);
    }

    /**
     * within the range of[l,r] in the treeIndex-root line segment tree,
     * search for the value of the interval[queryL,queryR]
     *
     * the process can reference image/structure/aj_segment_tree/ab_queryProcess.jpg
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int treeIndex,int l, int r,int queryL,int queryR){
        if(l == queryL && r == queryR){
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if(queryL >= mid + 1){
            //return query(rightTreeIndex,r,data.length - 1,queryL,queryR);
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        }else if(queryR <= mid){
            return query(leftTreeIndex,l,mid,queryL,queryR);
        }

        E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
        E rightResult = query(rightTreeIndex,mid + 1,r,mid + 1,queryR);
        System.out.println(merger);
        return merger.merge(leftResult,rightResult);

    }

    /**
     * update the {@index} position element to e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index > data.length){
            throw new IllegalArgumentException("Index is Illegal");
        }

        set(0,0,data.length - 1,index,e);
    }

    private void set(int treeIndex,int l,int r,int index, E e){
        if(l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r -l) / 2 ;

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(index <= mid){
            set(leftTreeIndex,l,mid,index,e);
        }else{
            set(rightTreeIndex,mid + 1,r,index,e);
        }

        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[treeIndex]);
    }



    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        //System.out.println(segTree);

        //System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        //System.out.println(segTree.query(0, 5));
    }

}
