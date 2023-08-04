class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        int index = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==postorder[postorder.length-1]){
                index=i;break;
            }
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        root.left = buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(inorder,index+1,inorder.length),Arrays.copyOfRange(postorder,index,postorder.length-1));
        return root;
    }
}
//O(N) SOLUTION
class Solution {
    int[] inorder, postorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildHelper(0,inorder.length-1,0,postorder.length-1);
    }

    public TreeNode buildHelper(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(root.val);
        int rightLength = inEnd - index;
        root.left = buildHelper(inStart, index-1, postStart, postEnd - rightLength - 1);
        root.right = buildHelper(index+1,inEnd,postEnd - rightLength, postEnd-1);
        return root;
    }
}
