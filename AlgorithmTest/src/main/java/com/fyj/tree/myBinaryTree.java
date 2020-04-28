package com.fyj.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 * @author fyj
 */
public class myBinaryTree {


    /**
     * 构建二叉树
     * @param inputList
     * @return
     * {3,2,9,null,null,10,null,null,8,null,4}
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){

        TreeNode node = null;
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        if(data != null){
            node =  new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preOrderTraveral(TreeNode node){

        if(null==node){
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树非递归前序遍历  栈：逻辑结构，FILO
     * @param root 二叉跟节点
     */
    public static void preOrderTraveralWithStack(TreeNode root){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while(treeNode != null || !stack.isEmpty()){
            while(treeNode != null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }


            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }

    }

    /**
     * 二叉树的层序遍历  队列，逻辑结构 FIFO
     * @param root
     */
    public static void levelOrderTraveral(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
             TreeNode node = queue.poll();
             System.out.println(node.data);
             if(node.leftChild != null){
                 queue.offer(node.leftChild);
             }
             if(node.rightChild != null){
                 queue.offer(node.rightChild);
             }
        }

    }

    /**
     * 二叉树节点
     */
    private static class TreeNode{

        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data){
            this.data=data;
        }
    }

    public static void main(String[] args){
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode treeNode = createBinaryTree(inputList);
        preOrderTraveral(treeNode);
        preOrderTraveralWithStack(treeNode);
        levelOrderTraveral(treeNode);
    }

}
