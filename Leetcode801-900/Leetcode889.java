class Solution {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length==0) return null;
        if(preorder.length==1) return new TreeNode(preorder[0]);
        int index = -1;
        for(int i=0;i<postorder.length;i++){
            if(postorder[i]==preorder[1]){
                index=i;
                break;
            }
        }
        TreeNode node = new TreeNode(preorder[0]);
        int[] postorderLeft = Arrays.copyOfRange(postorder,0,index+1);
        int[] postorderRight = Arrays.copyOfRange(postorder,index+1,postorder.length-1);
        int[] preorderLeft = Arrays.copyOfRange(preorder,1,index+2);
        int[] preorderRight = Arrays.copyOfRange(preorder,index+2,preorder.length);
        node.left = constructFromPrePost(preorderLeft,postorderLeft);
        node.right = constructFromPrePost(preorderRight,postorderRight);
        return node;
    }
}
