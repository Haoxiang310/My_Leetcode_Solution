class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    int i = 0;

    //it's impossible that the next node has a lowerbound less than curr node(The root node has a lowerbound of MIN_VALUE)
    // so we only need to maintain upperbound
    public TreeNode helper(int[] preorder, int upper){
        if(i == preorder.length || preorder[i] > upper) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = helper(preorder, root.val);
        root.right = helper(preorder, upper);
        return root;
    }
}
