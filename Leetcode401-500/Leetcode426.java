//Recursion
class Solution {
    Node pre = null, head = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        inorderTraverse(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    public void inorderTraverse(Node root){
        if(root==null) return;
        inorderTraverse(root.left);
        if(head == null) head = root;
        root.left = pre;
        if(pre!=null) pre.right = root;
        pre = root;
        inorderTraverse(root.right);
    }
}

//Iterative
class Solution {
    Node head = null, prev = null;
    public Node treeToDoublyList(Node root) {
        if(root==null) return root;
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root !=null ){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(head == null) head = root;

            if(prev !=null){
                prev.right = root;
                root.left = prev;
            }
            prev = root;
            root = root.right;
        }
        prev.right = head;
        head.left = prev;
        return head;
    }
}
