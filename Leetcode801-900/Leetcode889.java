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

O(N) solution
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    int[] preorder, postorder;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length == 0) return null;
        this.preorder = preorder;
        this.postorder = postorder;
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return buildHelper(0,preorder.length-1,0,postorder.length-1);
    }

    public TreeNode buildHelper(int preStart, int preEnd, int postStart, int postEnd){
        if(preStart > preEnd || postStart > postEnd) return null;
 
        if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }
               TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart+1]);
        int leftTreeSize = index - postStart;
        root.left = buildHelper(preStart+1,preStart+1+leftTreeSize,postStart,postStart+leftTreeSize);
        root.right = buildHelper(preStart+2+leftTreeSize,preEnd,postStart+leftTreeSize+1,postEnd-1);
        return root;
    }
}
