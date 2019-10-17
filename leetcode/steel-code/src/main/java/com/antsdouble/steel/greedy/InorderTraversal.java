package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author lyy
 * @Deprecated  二叉树的中序遍历
 * @date 2019/10/17
 */
public class InorderTraversal {
    public List<Integer> solution(TreeNode treeNode) {
        return getResult(treeNode);
    }

    private List<Integer> getResult(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null) {
            return result;
        } else {
            if (root.left != null) {
                result.addAll(getResult(root.left));
            }
            result.add(root.val);
            if (root.right != null) {
                result.addAll(getResult(root.right));
            }
            return result;
        }

    }

    private List<Integer> getResultByIterativer(TreeNode root){
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            list.add(root.val);
            root=root.right;
        }

        return list;
    }
}
