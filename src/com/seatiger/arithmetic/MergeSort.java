package com.seatiger.arithmetic;

/**
 * 归并排序,原地归并排序
 */
public class MergeSort {

    private static Comparable[] temp;

    public static void sort(Comparable[] comparables){
        //初始化临时数组
        temp = new Comparable[comparables.length];

        sort(comparables,0,comparables.length - 1);
    }

    //将数组comparables[left...right]排序
    private static void sort(Comparable[] comparables, int left, int right) {
        if(right <= left) return;
        int mid = left + (right - left) / 2; //获取中间值
        sort(comparables,left,mid);//左边排序
        sort(comparables,mid + 1,right);//左边排序
        //将左右两边合并
        merge(comparables,left,mid,right);
    }

    //将comparables[left,..mid]和comparables[mid+1,right]排好序的数组合并
    private static void merge(Comparable[] comparables, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        //将left-right的数据拷贝到临时数组中
        for(int k = left;k <= right;k++){
            temp[k] = comparables[k];
        }
        //把temp中的数据按照大小,放回原数组中
        for(int k = left; k <= right;k++){
            if(j > right){
                comparables[k] = temp[i++];
            }else if(i > mid){
                comparables[k] = temp[j++];
            }else if(temp[i].compareTo(temp[j]) > 0){
                comparables[k] = temp[j++];
            }else{
                comparables[k] = temp[i++];
            }
        }
    }

    private static void print(Comparable[] comparables){
        for (Comparable comparable : comparables){
            System.out.print(comparable+ " ");
        }
    }

    public static void main(String[] args) {
        Integer[] integer = new Integer[]{3,9,-1,10,8,-2,17,0,7,44,19};
        MergeSort.sort(integer);
        print(integer);

    }


}
