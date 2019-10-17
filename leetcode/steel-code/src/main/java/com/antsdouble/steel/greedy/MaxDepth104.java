package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class MaxDepth104 {
    public int solution(TreeNode root) {
        return findMax(root);
    }

    private int findMax(TreeNode treeNode) {
        if (treeNode == null)
            return 0;

        int leftRes = 0;
        int rightRes = 0;
        if (treeNode.left != null) {
            leftRes = findMax(treeNode.left);
        }
        if (treeNode.right != null) {
            rightRes = findMax(treeNode.right);
        }
        return Math.max(leftRes, rightRes) + 1;
    }

    private int findMaxUseIteration(TreeNode treeNode) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<Pair<TreeNode, Integer>>();
        if (treeNode != null) {
            stack.add(new Pair(treeNode, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            treeNode = current.getKey();
            int current_depth = current.getValue();
            if (treeNode != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(treeNode.left, current_depth + 1));
                stack.add(new Pair(treeNode.right, current_depth + 1));
            }
        }
        return depth;
    }
}
