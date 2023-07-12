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
    public int LEAF = 0;//叶子节点
    public int WITHCAMERA = 1;//有camera的节点
    public int COVEREDWITHNOCAMERA = 2;//被覆盖但是没有camera的节点
    int res = 0;
    //greedy,给所有leaf节点的parent camera，然后remove所有被覆盖的节点
    public int minCameraCover(TreeNode root) {
        return (dfs(root)<1?1:0)+res;
    }

    public int dfs(TreeNode root){
        if(root==null) return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == 0 || right == 0){
            res++;
            return 1;
        }
        if(left == 1 || right == 1){
            return 2;
        }
        if(left == 2 && right == 2){
            return 0;
        }
        return -1;
    }
}
