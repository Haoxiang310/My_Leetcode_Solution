
class Solution {


    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root){
        if(root==null) return;
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root!=null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if(curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) stack.push(curr.left);
        }
        return res;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            else{
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return res;
    }
}
