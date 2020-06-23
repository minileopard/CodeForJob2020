package others;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class ccbl_dg {
    //递归实现二叉树层次遍历
    List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n4.left = n2; n4.right = n6;
        n2.left = n1; n2.right = n3;
        n6.left = n5; n6.right = n7;

        ccbl_dg c = new ccbl_dg();
        int depth = c.depth(n4);
        for(int i = 1; i <= depth; i++)
        {
            c.find(n4, i);
        }

        System.out.println(c.list.toString());
    }
    void find(TreeNode tree, int level)
    {
        if(tree == null || level < 1)
            return;
        if(level == 1)
        {
            list.add(tree.val);
        }
        find(tree.left, level - 1);
        find(tree.right, level - 1);
    }
    //二叉树最大深度
    int depth(TreeNode root)
    {
        if(root == null)
            return 0;
        int maxleft = depth(root.left);
        int maxright = depth(root.right);
        return Math.max(maxleft, maxright) + 1;
    }
}
/*
https://www.cnblogs.com/QoQian/p/5438278.html
 */