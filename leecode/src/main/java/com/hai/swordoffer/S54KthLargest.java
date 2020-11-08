package com.hai.swordoffer;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class S54KthLargest {

    int res, count;
    public int kthLargest(TreeNode root, int k) {
        this.count = k;
        dfs(root);
        return res;


    }

    public void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.right);
        if (--count == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}
