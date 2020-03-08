package com.seatiger.structure.aa_array.aa_array_base;

/**
 * introduce basic array
 * store data in row
 *
 *            0   1   2   3    ----> 索引 index
 *          +---+---+---+---+
 * arrays   |   |   |   |   |
 *          +---+---+---+---+
 *                |
 *                |
 *              arrays[1]
 *
 *  the greatest advantages of array is that can quick to query
 *
 *  arrays are best used when the index is semantic,
 *  for example, the students score can be stored using array,
 *  the students number can be used as indexes,so if you want
 *  to know a student's grade ,you can get immediately like scores[number]
 *
 *
 *  but not all semantic indexes apply to arrays
 *  like person's identity card
 *
 */
public class IntroduceArray {

    /**
     * a Main method that test the use of basic array
     * @param args
     */
    public static void main(String[] args) {
        //define an array of length 10
        int[] arrays = new int[10];

        //assign values to the array
        for(int i = 0;i< arrays.length;i++){
            arrays[i] = i;
        }

        //could define an array that has meaningful name,and initialize immediately
        int[] scores = new int[]{91,92};

        //traverse the two arrays above
        for(int array : arrays){
            System.out.print(array + ",");
        }

        System.out.println();

        for(int score : scores){
            System.out.print(score + ",");
        }
    }
}
