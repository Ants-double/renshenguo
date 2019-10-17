package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lyy
 * @Deprecated 二叉树的前序遍历
 * @date 2019/10/17
 */
public class PreOrderTraversal {
    public List<Integer> solution(TreeNode root){
        return  getResult(root);
    }
    private  List<Integer> getResult(TreeNode treeNode){
        List<Integer> result=new ArrayList<Integer>();
        if (treeNode==null){
            return result;
        }
        else {
            result.add(treeNode.val);
            if (treeNode.left!=null){
                result.addAll(getResult(treeNode.left));
            }
            if (treeNode.right!=null){
                result.addAll(getResult(treeNode.right));
            }
        }
        return  result;
    }

    private List<Integer> getResultByStack(TreeNode treeNode){
        List<Integer> result=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while (treeNode!=null||!stack.isEmpty()){
            if (treeNode!=null){
                result.add(treeNode.val);
                stack.push(treeNode);
                treeNode=treeNode.left;
            }
            else {
                treeNode=stack.pop().right;
            }
        }
        return result;
    }
}
