class Solution {
    public List<TreeNode> generateTrees(int n) {
        return buildTree(1,n);
        
    }

    public List<TreeNode> buildTree(int lo, int hi){
        List<TreeNode> res = new ArrayList<>();
        if(lo>hi){
            res.add(null);
            return res;
        }
        for(int i=lo;i<=hi;i++){
            List<TreeNode> left = buildTree(lo,i-1);
            List<TreeNode> right = buildTree(i+1,hi);
            
            for(TreeNode l:left){
                for(TreeNode r:right){
                    //res.add need to new TreeNode
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
