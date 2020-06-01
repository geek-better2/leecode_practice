package com.hai.leecode.tree;

/**
 * 镜像二叉树
 * @author hai
 * @date 2020-05-27 10:50
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }



}
