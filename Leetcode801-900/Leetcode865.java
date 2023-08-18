class Pair{
    int d;
    TreeNode root;
    Pair(int d, TreeNode root){
        this.d = d;
        this.root = root;
    }
}
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root,0).root;
    }

    //return the depth of the deepest leave node of current SubTree
    //and the TreeNode of LCA of the leaves in the current SubTree
    public Pair dfs(TreeNode root, int depth){
        if(root == null) return new Pair(depth, root);
        Pair left = dfs(root.left, depth + 1);
        Pair right = dfs(root.right, depth + 1);
        if(left.d == right.d) return new Pair(left.d, root);
        else if(left.d > right.d) return new Pair(left.d, left.root);
        else return new Pair(right.d, right.root);
    }
}
