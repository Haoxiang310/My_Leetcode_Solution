class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null) stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(0,root.val);
            if(root.left!=null) stack.push(root.left);
            if(root.right!=null) stack.push(root.right);
        }
        return res;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> resStack = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                resStack.push(curr);
                curr = curr.right;
            }
            else{
                curr = stack.pop();
                curr = curr.left;
            }
        }
        while(!resStack.isEmpty()) res.add(resStack.pop().val);
        return res;
    }
}


