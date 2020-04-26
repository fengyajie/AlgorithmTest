package com.fyj.myLinkedList;

/**
 * @author fyj
 * 物理结构
 */
public class SigleLinkedList {

    //头节点指针
    private Node head;

    //尾节点指针
    private Node last;

    //链表长度
    private int size;


    /**
     * 链表插入元素
     * @param data
     * @param index
     * @throws Exception
     */
    public void insert(int data,int index) throws  Exception{
        if(index <0 || index >size){
            throw new IndexOutOfBoundsException("超过链表元素节点范围");
        }
        Node insertedNode = new Node(data);
        if(size == 0){
            //空链表
            head = insertedNode;
            last = insertedNode;
        }else if(0==index){
            //插入头节点
            insertedNode.next=head;
            head = insertedNode;
        }else if(size==index){
            //插入尾部
           last.next=insertedNode;
           last = insertedNode;
        }else{
            //插入中间
            Node preNode = get(index-1);
            insertedNode.next=preNode.next;
            preNode.next=insertedNode;
        }

        size++;
    }

    /**
     * 删除链表元素
     * @param index
     * @return
     * @throws Exception
     */
    public Node delete(int index) throws  Exception{
        if(index <0||index >=size){
           throw  new IndexOutOfBoundsException("超过链表节点范围");
        }
        Node deletedNode = null;
        if(index==0){
            //删除头节点
            deletedNode = head;
            head = head.next;
        }else if(index == size-1){
            //删除尾节点
            deletedNode = last;
            Node preNode = get(index-1);
            preNode.next = null;
            last = preNode;
        }else{
            //删除中间节点
            Node preNode = get(index-1);
            deletedNode = preNode.next;
            preNode.next = preNode.next.next;
        }

        size--;
        return deletedNode;
    }
    /**
     * 链表查找元素
     * @param index 查找的位置
     * @return
     * @throws Exception
     */
    public Node get(int index) throws  Exception{

        if(index <0 || index >= size){
            throw  new IndexOutOfBoundsException("超过链表元素节点范围");
        }
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }


    /**
     * 输出链表
     */
    public void output(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    public static void main(String[] args){
        try {
            SigleLinkedList sigleLinkedList = new SigleLinkedList();
            sigleLinkedList.insert(1, 0);
            sigleLinkedList.insert(2,1);
            sigleLinkedList.output();
            sigleLinkedList.delete(0);
            sigleLinkedList.output();
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    private static class Node{
        int data;
        Node next;
        Node(int data){
         this.data=data;
        }
    }
}
