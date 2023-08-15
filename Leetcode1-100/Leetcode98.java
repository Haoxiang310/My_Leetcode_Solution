//inorder position judge if current node value if greater than previous node value
//since the inorder traversal should be an increasing sequence
class Solution {
    Long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean leftSub = isValidBST(root.left);
        if(!leftSub) return false;
        if(root.val <= prev) return false;
        prev = (long)root.val;
        return isValidBST(root.right);
    }
}

//iteration
class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                root = stack.pop();
                if(prev != null && prev.val >= root.val) return false;
                prev = root;
                root = root.right;
            }
        }
        return true;
    }
}
