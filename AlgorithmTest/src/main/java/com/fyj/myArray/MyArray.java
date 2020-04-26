package com.fyj.myArray;

/**
 * @author fyj
 * 物理结构
 */
public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int capacity){
       this.array=new int[capacity];
       size = 0;
    }

    /**
     * 插入
     * @param element 数组元素
     * @param index  下标
     * @throws Exception
     */
    public void insert(int element,int index) throws Exception{
        if(index < 0 || index > size){
          throw  new IndexOutOfBoundsException("超出数组的实际元素范围!");
        }

        //如果实际元素达到数组容量上限，则对数组进行扩容
        if(size >= array.length){
            resize();
        }

        //从右向左循环，将元素逐个向右挪一位
        for(int i=size-1;i>=index;i--){
           array[i+1]=array[i];
        }
        //插入元素
        array[index] = element;
        size++;
    }

    /**
     * 删除元素
     * @param index
     * @return
     * @throws Exception
     */
    public int delete(int index) throws Exception{
        if(index <0 || index >=size){
            throw new IndexOutOfBoundsException("超出数组的实际元素范围");
        }
        int deletedElement = array[index];
        for(int i=index;i<size-1;i++){
           array[i]=array[i+1];
        }
        size--;
        return deletedElement;
    }

    public void output(){
        for(int i = 0;i<size;i++){
            System.out.println(array[i]);
        }
    }
    /**
     * 数组扩容
     */
    public void resize(){
        int[] arrayNew = new int[array.length*2];
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
    }

    public static void main(String[] args){
        try {
            MyArray myArray = new MyArray(2);
            myArray.insert(1, 0);
            myArray.insert(2,1);
            myArray.insert(3,2);
            myArray.output();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
