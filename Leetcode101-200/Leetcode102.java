class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        int step = 0;
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
            res.add(new ArrayList<>());
            int sz = q.size();
            for(int i=0;i<sz;i++){
                TreeNode curr = q.poll();
                res.get(step).add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            step++;
        }
        return res;
    }
}
