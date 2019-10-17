package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> solution(TreeNode root) {
        return getResult(root);
    }

    private List<List<Integer>> getResult(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offerFirst(root);
        boolean startLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.pollLast();
                if (n.left != null) queue.offerFirst(n.left);
                if (n.right != null) queue.offerFirst(n.right);
                //插入位置
                if (startLeft)
                    level.add(n.val);
                else
                    level.add(0, n.val);
            }
            result.add(level);
            startLeft = !startLeft;
        }
        return result;
    }
}
