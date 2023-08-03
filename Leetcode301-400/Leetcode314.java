class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<TreeNode, Integer> position = new HashMap<>();
        Map<Integer, List<Integer>> colToNode = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.add(root);
        position.put(root,0);
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int col = position.get(curr);
            colToNode.computeIfAbsent(col,x->new ArrayList<>()).add(curr.val);
            if(curr.left!=null){
                q.add(curr.left);
                position.put(curr.left,col-1);
            }
            if(curr.right!=null){
                q.add(curr.right);
                position.put(curr.right,col+1);
            }
            min = Math.min(min, col);
        }
        while(colToNode.containsKey(min)) res.add(colToNode.get(min++));
        return res;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<int[]>> colToNode = new TreeMap<>();
        dfs(root,0,0,colToNode);
        //TreeMap will automatically sort by keys
        for(List<int[]> nodes: colToNode.values()){
            Collections.sort(nodes,(node1,node2)->{
                return node1[0]-node2[0];
            });
            List<Integer> tmp = new ArrayList<>();
            for(int[] node:nodes){
                tmp.add(node[1]);
            }
            res.add(tmp);
        }
        return res;
    }

    public void dfs(TreeNode root, int depth, int col, Map<Integer, List<int[]>> colToNode){
        if(root==null) return;
        if(!colToNode.containsKey(col)){
            colToNode.put(col, new ArrayList<>());
        }
        colToNode.get(col).add(new int[]{depth,root.val});
        dfs(root.left,depth+1,col-1,colToNode);
        dfs(root.right,depth+1,col+1,colToNode);
        return;
    }
}
