package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.TreeNode;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class ValidBST {
    private  int last;
    private boolean isFirst=true;
    public boolean solution(TreeNode root){
        return getResult(root);
    }
    private boolean getResult(TreeNode treeNode){

        if (treeNode==null){
            return true;
        }
        if (getResult(treeNode.left)){
            if (last<treeNode.val||isFirst==true){
                isFirst=false;
                last=treeNode.val;
                return getResult(treeNode.right);
            }
        }
        return false;
    }
}
