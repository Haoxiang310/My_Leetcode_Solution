/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//pure recursion
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

//dfs
class Solution {

    HashMap<TreeNode, TreeNode> map = new HashMap<>(); //(parent, node)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, null);
        Set<TreeNode> set = new HashSet<>();
        while(p != null){
            set.add(p);
            p = map.get(p);
        }
        while(!set.contains(q)){
            q = map.get(q);
        }
        return q;
    }

    public void dfs(TreeNode root, TreeNode parentNode){
        if(root == null) return;
        map.put(root,parentNode);
        dfs(root.left,root);
        dfs(root.right,root);
    }
}
