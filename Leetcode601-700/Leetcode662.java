/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int res = 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        if(root != null) q.offer(root);
        map.put(root, 0);
        int left = 0, right = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            left = 0; right = 0;
            for(int i=0;i<sz;i++){
                TreeNode curr = q.poll();
                if(i == 0) left = map.get(curr);
                if(i == sz-1) right = map.get(curr);
                if(curr.left != null){
                    q.offer(curr.left);
                    map.put(curr.left, 2 * map.get(curr));
                }
                if(curr.right != null){
                    q.offer(curr.right);
                    map.put(curr.right, 2 * map.get(curr) + 1);
                }
            }
            res = Math.max(right-left+1, res);
        }
        return res;
    }
}
