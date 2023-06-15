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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root,p,q);
    }

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        
        TreeNode left = find(root.left,p,q);
        TreeNode right = find(root.right,p,q);
        if(left!=null && right!=null) return root;
        if(root.val==p.val || root.val==q.val) return root;
        return left==null?right:left;
    }
}
