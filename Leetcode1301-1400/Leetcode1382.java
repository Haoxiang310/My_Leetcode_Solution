class Solution {
    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);
        return build(list,0,list.size()-1);
    }

    public TreeNode build(List<Integer> list, int left, int right){
        if(left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(list, left, mid-1);
        root.right = build(list, mid+1,right);
        return root;
    }

    public void inOrderTraversal(TreeNode root){
        if(root == null) return;
        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }
}
