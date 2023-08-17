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

    boolean findP, findQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

       TreeNode res = find(root,p,q);
       return findP&&findQ?res:null;
    }

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        TreeNode left = find(root.left,p,q);
        TreeNode right = find(root.right,p,q);
        if(left!=null && right!=null) return root;
        if(root.val==p.val){
            findP = true;
            return root;
        }
        if(root.val==q.val){
            findQ = true;
            return root;
        }
        return left!=null?left:right;
    }
}

//postorder one pass
class Solution {
    int cnt = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = LCA(root, p, q);
        return cnt == 2 ? res : null;
    }
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if(root == p || root == q){
            cnt++;
            return root;
        }
        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;

        return null;
    }
}
