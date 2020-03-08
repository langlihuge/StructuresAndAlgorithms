package com.seatiger.structure.ae_recursion.aa_recursion_basic;

/**
 * recursion
 * Essentially, we're talking the original problem and turning it into smaller problem
 *
 * for example:
 * Sum( arr[0…n-1] ) = arr[0] + Sum( arr[1…n-1] )  ---> the same smaller problem
 * Sum( arr[1…n-1] ) = arr[1] + Sum( arr[2…n-1] )  ---> the same smaller problem
 *                      ............
 * Sum( arr[n-1…n-1] ) = arr[n-1] + Sum( [] )      ---> the basic problem
 *
 *
 * the process can reference \image\structure\ae_recursion\aa_process_sum.jpg
 *
 */
public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    /**
     *  the sum of between @{l} to n   arr[l ,n)
     *
     *  when l == arr.length that is the basic problem
     *
     *  should take the original problem and turning it into smaller problem
     * @param arr
     * @param l
     * @return
     */
    private static int sum(int[] arr, int l) {

        if(l == arr.length){
            return 0;
        }

        return arr[l] + sum(arr, l+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(sum(nums));
    }

}
