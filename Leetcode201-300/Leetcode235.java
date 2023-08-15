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

    public TreeNode find(TreeNode root,TreeNode p, TreeNode q){
        if(root==null) return null;
        int p1 = Math.min(p.val,q.val);
        int q1 = Math.max(p.val,q.val);
        if(root.val>=p1 && root.val<=q1) return root;
        else if(root.val<p1) return find(root.right,p,q);
        else if(root.val>q1) return find(root.left,p,q);
        return null;
    }
}

//Recursion
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}

//iterative
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val > p.val && root.val > q.val) root = root.left;
            else if(root.val < p.val && root.val < q.val) root = root.right;
            else break;
        }
        return root;
    }
}
