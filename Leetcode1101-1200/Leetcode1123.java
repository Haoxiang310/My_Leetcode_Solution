//O(N^2) Solution
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight == rightHeight) return root;
        else if(leftHeight > rightHeight) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }

    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
//pure recursion O(N) Solution
class Solution {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return getLCA(root, 0).root;
    }

    //return lca of all the deepest leaves of current subtree under current root
    public Pair getLCA(TreeNode root, int depth) {
        if(root == null) return new Pair(root, depth);
        Pair left = getLCA(root.left, depth + 1);
        Pair right = getLCA(root.right, depth + 1);
        if(left.depth == right.depth) return new Pair(root,left.depth);
        else return left.depth > right.depth ? left : right;
    }
}

class Pair{
    TreeNode root;
    int depth;
    Pair(TreeNode root, int depth){
        this.root = root;
        this.depth = depth;
    }
}
