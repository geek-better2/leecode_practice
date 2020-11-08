package com.hai.swordoffer;

/**剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class S69LowestCommonAncestor2 {

    /**
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorPlus(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorPlus(root.left, p, q);
        TreeNode right = lowestCommonAncestorPlus(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
