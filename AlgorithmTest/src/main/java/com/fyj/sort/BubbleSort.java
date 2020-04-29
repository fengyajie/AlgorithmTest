package com.fyj.sort;

import java.util.Arrays;

/**
 * @author fyj
 * 冒泡排序第一版
 */
public class BubbleSort {

    /**
     * 冒泡排序--第一版
     * @param array
     */
    public static void sortOne(int[] array){

        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                int temp=0;
                if(array[j] >array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1] = temp;
                }

            }
        }
    }

    /**
     * 冒泡排序--第二版
     * @param array
     */
    public static void sortTwo(int[] array){

        for(int i=0;i<array.length-1;i++){

            boolean sortFlag = true;
            for(int j=0;j<array.length-i-1;j++){
                int temp=0;
                //没有元素交换说明已经有序
                if(array[j] >array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1] = temp;
                    sortFlag = false;
                }
            }

            if(sortFlag){
                break;
            }

        }
    }

    public static void sortThree(int[] array){
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界
        int sortBorder = array.length-1;

        for(int i=0;i<array.length-1;i++){

            boolean isSorted = true;

            for(int j=0;j<sortBorder;j++){
                int temp = 0;
                 if(array[j] >array[j+1]){
                     temp = array[j];
                     array[j] = array[j+1];
                     array[j+1] = temp;

                     isSorted = false;
                     lastExchangeIndex = j;
                 }
            }

            sortBorder = lastExchangeIndex;

            if(isSorted){
                break;
            }
        }
    }

    public static void main(String[] args){
        //int[] array = new int[]{7,8,5,9,2,4,3};
        int[] array = new int[]{3,4,2,1,5,6,7,8};
        //sortOne(array);
        //sortTwo(array);
        sortThree(array);
        System.out.println(Arrays.toString(array));
    }
}
