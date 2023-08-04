class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        if(preorder.length==1) return new TreeNode(preorder[0]);
        int index = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[index]) {
                index=i;
                break;
            }
        }
        int[] leftPre = Arrays.copyOfRange(preorder,1,1+index);
        int[] rightPre = Arrays.copyOfRange(preorder,1+index,preorder.length);
        int[] leftIn = Arrays.copyOfRange(inorder,0,index);
        int[] rightIn =Arrays.copyOfRange(inorder,index+1,inorder.length);
        TreeNode leftChild = buildTree(leftPre,leftIn);
        TreeNode rightChild = buildTree(rightPre, rightIn);
        TreeNode root = new TreeNode(preorder[0]);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}

//O(N) Solution
class Solution {
    int[] preorder, inorder;
    int preorderIndex = 0;
    //<inorder value, index>, reduce time complexity to O(N)
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildHelper(0,inorder.length-1);
    }

    public TreeNode buildHelper(int inStart, int inEnd){
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        int index = map.get(root.val);
        root.left = buildHelper(inStart, index-1);
        root.right = buildHelper(index+1, inEnd);
        return root;
    }
}

