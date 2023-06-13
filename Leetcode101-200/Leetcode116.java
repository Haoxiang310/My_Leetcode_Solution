class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        traverseTernaryTree(root.left,root.right);
        return root;
    }

    void traverseTernaryTree(Node node1, Node node2){
        if(node1 == null && node2 == null) return;
        node1.next=node2;
        traverseTernaryTree(node1.left,node1.right);
        traverseTernaryTree(node1.right,node2.left);
        traverseTernaryTree(node2.left,node2.right);
    }
}
