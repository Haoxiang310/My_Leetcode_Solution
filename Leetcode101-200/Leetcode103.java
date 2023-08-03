class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode curr = q.poll();
                if(flag) level.add(curr.val);
                else level.add(0,curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            flag = !flag;
            res.add(level);
        }
        return res;
    }
}
