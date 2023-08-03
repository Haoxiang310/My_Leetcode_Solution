class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root,0);
        return res;
    }

    public void dfs(TreeNode root, int step){
        if(root==null) return;
        if(step == res.size()){
            res.add(0,new ArrayList<>());
        }
        res.get(res.size()-step-1).add(root.val);
        dfs(root.left,step+1);
        dfs(root.right,step+1);
        return;
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
            res.add(0,new ArrayList<>());
            for(int i = q.size();i>0;i--){
                TreeNode curr = q.poll();
                res.get(0).add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return res;
    }
}
