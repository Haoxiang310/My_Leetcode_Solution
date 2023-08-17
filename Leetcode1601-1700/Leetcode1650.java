/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p1=p;
        Node q1=q;
        while(p1!=q1){
            p1=p1.parent;
            q1=q1.parent;
            if(p1==null) p1=q;
            if(q1==null) q1=p;
        }
        return p1;
    }
}

//when two same node exist in set, this node must be their LCA
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        while(true){
            if(p != null && !set.add(p)) return p;
            if(q != null && !set.add(q)) return q;
            if(p != null) p = p.parent;
            if(q != null) q = q.parent;
        }
    }
}

//same as find intersection of linkedlist Leetcode 160
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while(a != b){
            a = (a == null) ? p : a.parent;
            b = (b == null) ? q : b.parent;
        }
        return a;
    }
}
