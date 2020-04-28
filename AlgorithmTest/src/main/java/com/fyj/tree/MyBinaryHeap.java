package com.fyj.tree;

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

        while(temp >0 && temp <array[parentIndex]){

            //把父节点值赋给子节点，最下面的叶子节点为temp，并没有覆盖，如此循环，直到不满足条件
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex-1)/2;
        }
        array[childIndex] = temp;
    }
}
