package lc_dataStructure;

import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
public class Pro652 {
    List<TreeNode> result;
    Map<Integer, Integer> counts;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new ArrayList();
        counts = new HashMap();
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 3524335;
        int id = ((dfs(node.left) ^ 3) * 3423443 + (dfs(node.right) ^ 13)) * 3423443 + node.val;
        int count = counts.getOrDefault(id, 0) + 1;
        if (count == 2) {
            result.add(node);
        }
        counts.put(id, count);
        return id;
    }
    private int dfs2(TreeNode node) {
        if (node == null) return 1111;
        int id = ((dfs(node.left) ^ 3) * 1111 + (dfs(node.right) ^ 5)) * 1111 + node.val;
        int count = counts.getOrDefault(id, 0) + 1;
        if (count == 2) {
            result.add(node);
        }
        counts.put(id, count);
        return id;
    }
    /*
    //我的实现方案
    Map<String,Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
    public List<Integer> dfs(TreeNode root)
    {
        if(root == null)
            return new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        List<Integer> tl = dfs(root.left);
        List<Integer> tr = dfs(root.right);
        if(tl.isEmpty())
        {
            tl.add(null);
        }
        if(tr.isEmpty())
        {
            tr.add(null);
        }
        for(Integer i:tl)
        {
            temp.add(i);
        }
        for(Integer i:tr)
        {
            temp.add(i);
        }
        String key = Arrays.toString((Integer[])(temp.toArray(new Integer[temp.size()])));
        int count = map.getOrDefault(key, 0);
        if(count == 1)
        {
            res.add(root);
        }
        map.put(key, count + 1);
        return temp;
    }
    */
}
