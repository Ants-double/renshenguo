package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lyy
 * @Deprecated 二叉查找树 95
 * @date 2019/10/17
 */
public class BinarySearchTree {

    public List<TreeNode> solution(int n){
        return  getResult(n);
    }

    private List<TreeNode> getResult(int num){
        List<TreeNode> result=new ArrayList<TreeNode>();
        if (num<0){
            return null;
        }
        if(num==0){
            return result;
        }

        return generateTrees(1,num);
    }
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> res=new LinkedList<TreeNode>();
        if (start>end){
            res.add(null);
            return res;
        }
        for (int i=start;i<=end;i++){
            List<TreeNode> left=generateTrees(start,i-1);
            List<TreeNode> right=generateTrees(i+1,end);
            for (int j=0;j<left.size();j++){
                for (int k=0;k<right.size();k++){
                    TreeNode node=new TreeNode(i);
                    node.left=left.get(j);
                    node.right=right.get(k);
                    res.add(node);
                }
            }
        }
        return res;
    }
}
