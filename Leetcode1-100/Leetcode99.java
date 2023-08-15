//iterative solution
class Solution {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null, first = null, second = null;
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                root = stack.pop();
                if(prev != null && root.val <= prev.val){
                    if(first == null) {
                        first = prev;
                        //in case 2 wrong nodes are adjacent
                        second = root;
                    }
                    else second = root;
                }
                prev = root;
                root = root.right;
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }
}

class Solution {
    TreeNode prev = null, first = null, second = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }

    public void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        if(prev != null && root.val <= prev.val){
            if(first == null){
                first = prev;
                second = root;
            }
            else second = root;
        }
        prev = root;
        traverse(root.right);
    }
}
