package com.antsdouble.steel.greedy;


import com.antsdouble.steel.greedy.commons.TreeNode;

public class LongesUnivaluePath {
    public static void main(String[] args) {
        System.out.println(687);
        System.out.println(solution(null));
    }

    private static Integer result = 0;

    public static int solution(TreeNode root) {

        helper(root);
        return result;
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        left = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        right = (root.right != null && root.right.val == root.val) ? right + 1 : 0;

        result = Math.max(result, left + right);
        return Math.max(left, right);

    }
}
