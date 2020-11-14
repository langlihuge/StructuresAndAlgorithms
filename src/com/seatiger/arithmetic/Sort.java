package com.seatiger.arithmetic;

import java.util.Comparator;

/**
 * 需求:按升序排序
 * 基本思路: 对给定的一组数据,从下标较小的开始,依次和相邻的元素比较
 * 如果是逆序,则交换位置,这样第一个循环下来,可以把最大的那个放到最后面
 *
 */
public class Sort {


    /**
     * 冒泡排序
     * 基本思路: 对给定的一组数据,从下标较小的开始,依次和相邻的元素比较
     * 如果是逆序,则交换位置,这样第一个循环下来,可以把最大的那个放到最后面
     *
     * 3,9,-1,10,8
     *
     * 3 -1 9 8 10
     * -1 3 8 9 10
     * -1 3 8 9 10
     * -1 3 8 9 10
     * @param comparables
     */
    public static void bubbleSort(Comparable[] comparables){

        boolean flag = false;

        //外循环,下标从0开始
        for(int i = 0; i < comparables.length - 1;i++){
            //内循环,下标从1开始
            for(int j = 1; j < comparables.length - i; j++ ){
                //如果前一个比后面一个大,需要交换位置
                if(comparables[j-1].compareTo(comparables[j]) > 0){
                    //交换位置
                    swap(comparables,j-1,j);
                    flag = true;
                }
//                System.out.println();
            }
            //如果再依次排序中,没有发生交换,排序提前结束
            if (!flag){
                break;
            } else {
                flag = false;
            }
            //输出每次的排序结果
            print(comparables);

            System.out.println();
        }
    }

    /**
     * 找到数据组中最小的元素,然后最小的元素和第一个元素交换,如果第一个最小,自己和自己交换
     * 在剩下的元素中,找到最小的元素,然后和第二个元素交换
     * .....
     * @param comparables
     */
    public static void selectSort(Comparable[] comparables){
        for(int i =0; i < comparables.length;i++){
            int min = i; //最小元素的索引
            for(int j = i; j < comparables.length;j++){
                if(comparables[j].compareTo(comparables[min]) < 0){
                    min = j;
                }
            }
            swap(comparables,i,min);
            print(comparables);
            System.out.println();
        }
    }

    /**
     * 当前索引左边都是有序的,但是他们的最终位置不确定,
     * 需要把当前索引的元素插入左边有序元素的合适位置
     * 再插入之前,右边元素都要向右移动一位
     * @param comparables
     */
    public static void InsertSort(Comparable[] comparables ){
        for(int i =1 ; i< comparables.length;i++){
            //将a[i] 插入到i 前面的对应位置
            for(int j = i; j > 0 && (comparables[j-1].compareTo(comparables[j]) > 0) ; j--){
                swap(comparables,j-1,j);
            }
            print(comparables);
            System.out.println();
        }
    }

    /**
     * 把一个较大的数据分成步长为h的多个数组,换句话说,就有h个数组
     * 对这h个数组使用选择排序,使这h个相互独立的数组有序
     * 然后再缩小步长,分成若干个数组,分别排序,当步长为1时,说明整个数组有序
     * @param comparables
     */
    public static void shellSort(Comparable[] comparables) {
        int N = comparables.length;
        int h = 1;
        //初始化,刚开始的步长
        while (h < N / 3) h = 3 * h + 1;
        System.out.println(h);
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                //将a[i]插入到a[i-h],a[i - 2*h],a[i - 3h]中
                for (int j = i; j >= h && (comparables[j - h].compareTo(comparables[j]) > 0); j -= h) {
                    swap(comparables, j - h, j);
                }
            }
            h = h / 3;
            print(comparables);
            System.out.println();
        }
    }

    private static void print(Comparable[] comparables){
        for (Comparable comparable : comparables){
            System.out.print(comparable+ " ");
        }
    }

    private static void swap(Comparable[] comparables,int i,int j){
        Comparable temp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = temp;

    }

    public static void main(String[] args) {
        Integer[] integer = new Integer[]{3,9,-1,10,8,-2,17,0,7,44,19};
//        Sort.bubbleSort(integer);
//        Sort.selectSort(integer);
        Sort.shellSort(integer);
    }
}
