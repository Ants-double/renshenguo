package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.TreeNode;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class Symmetric {
    public boolean solution(TreeNode root) {
        return getResult(root);
    }

    private boolean getResult(TreeNode root) {
        return mirrorTree(root, root);
    }

    private boolean mirrorTree(TreeNode left, TreeNode right) {

        if (left == null) {
            return right == null;
        } else if (right == null) {
            return left == null;
        } else if (left.val == right.val) {
            return mirrorTree(left.left, right.right) && mirrorTree(left.right, right.left);
        } else {
            return false;
        }
    }
}
