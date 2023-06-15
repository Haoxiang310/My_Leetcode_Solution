/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<TreeNode> set = new HashSet<>();
        for(TreeNode node:nodes){
            set.add(node);
        }
        return find(root,set);
    }

    public TreeNode find(TreeNode root,HashSet<TreeNode> set){
        if(root==null) return null;
        if(set.contains(root)) return root;
        TreeNode left = find(root.left,set);
        TreeNode right = find(root.right,set);
        if(left!=null && right!=null) return root;
        return left!=null?left:right;
    }
}
