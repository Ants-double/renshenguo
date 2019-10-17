package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.TreeNode;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class SameTree {
    public boolean solution(TreeNode p, TreeNode q){
        return getResult(p,q);
    }

    private boolean getResult(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }
        if (p!=null&&q!=null&&p.val==q.val){
            return getResult(p.left,q.left)&&getResult(p.right,q.right);
        }else {
            return false;
        }
    }
}
