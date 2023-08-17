//BFS Solution
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        Queue<String> path = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        q.add(root);
        path.add(String.valueOf(root.val));
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            String curPath = path.poll();
            if(curr.left == null && curr.right == null){
                res.add(curPath);
                continue;
            }
            if(curr.left != null){
                path.offer(curPath + "->" + curr.left.val);
                q.offer(curr.left);
            }
            if(curr.right != null){
                path.offer(curPath + "->" + curr.right.val);
                q.offer(curr.right);
            }
        }
        return res;
    }
}

//DFS Solution
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root != null) {
            String path = String.valueOf(root.val);
            dfs(root, path, res);
        }
        return res;
    }

    public void dfs(TreeNode root, String path, List<String> res){
        if(root.left == null && root.right == null) {
            res.add(new String(path));
            return;
        }
        if(root.left != null) dfs(root.left, path+"->"+root.left.val, res);
        if(root.right != null) dfs(root.right, path+"->"+root.right.val, res);
        return;
    }
}
