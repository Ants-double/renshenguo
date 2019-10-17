package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lyy
 * @Deprecated 层次遍历
 * @date 2019/10/17
 */
public class LevelOrder {
    public List<List<Integer>> solution(TreeNode root) {
        return getResult(root);
    }


    private List<List<Integer>> getResult(TreeNode treeNode) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        pre(treeNode, 0, (ArrayList<List<Integer>>) result);
        return result;

    }


    private void pre(TreeNode treeNode, int depth, ArrayList<List<Integer>> list) {
        if (treeNode == null) {
            return;
        }
        if (depth >= list.size()) {
            list.add(new ArrayList<Integer>() {
            });
        }
        list.get(depth).add(treeNode.val);
        pre(treeNode.left, depth + 1, list);
        pre(treeNode.right, depth + 1, list);
    }

    private List<List<Integer>> getResultByQueue(TreeNode treeNode) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);
        if (treeNode == null) {
            return result;
        } else {

            while (!queue.isEmpty()){
                int count=queue.size();
                List<Integer> list=new ArrayList<Integer>();
                while (count>0){
                    TreeNode node=queue.poll();
                    list.add(node.val);
                    if (node.left!=null){
                        queue.add(node.left);
                    }
                    if (node.right!=null){
                        queue.add(node.right);
                    }
                    count--;
                }
                result.add(list);
            }
            return result;
        }
    }
}
