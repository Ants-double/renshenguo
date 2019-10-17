package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class RecoverTree {
    public void solution(TreeNode root) {
        getResult(root);
        return;

    }

    private void getResult(TreeNode treeNode) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        List<Integer> temp = new ArrayList<Integer>();
        inOrder(treeNode, list, temp);
        Collections.sort(temp);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).val = temp.get(i);
        }
        return;
    }

    private void inOrder(TreeNode node, List<TreeNode> list, List<Integer> temp) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list, temp);
        list.add(node);
        temp.add(node.val);
        inOrder(node.right, list, temp);
    }
}
