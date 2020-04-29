package com.fyj.tree;

import java.util.Arrays;

/**
 * @author fyj
 */
public class MyBinaryHeap {

    /**
     * 上浮调整
     * @param array 要调整的堆
     */
    public static void upAdjust(int[] array){

        //从叶子节点遍历
        int childIndex = array.length -1;
        //左叶子节点=2×parentIndex+1;右叶子节点=2×parentIndex+2;
        //父节点
        int parentIndex  = (childIndex-1)/2;

        //叶子值
        int temp = array[childIndex];

        while(childIndex >0 && temp <array[parentIndex]){

            //把父节点值赋给子节点，最下面的叶子节点为temp，并没有覆盖，如此循环，直到不满足条件
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex-1)/2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆长度
     */
    public static void downAdjust(int[] array,int parentIndex,int length){

        int temp = array[parentIndex];
        //左节点
        int childIndex = 2*parentIndex+1;

        while(childIndex < length){

            //右节点大于左节点
            if(childIndex+1 < length && array[childIndex] > array[childIndex+1]){

              childIndex++;
            }
            if(temp <= array[childIndex]){
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2*parentIndex+1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建二叉堆
     *又叶子节点 array.length=2*parentIndex+2
     * @param array
     */
    public static void buildHeap(int[] array){
        //从最后一个非叶子节点，依次做下沉
       for(int i=(array.length-2)/2;i>=0;i--){
           downAdjust(array,i,array.length);
       }
    }

    public static void main(String[] args){
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
