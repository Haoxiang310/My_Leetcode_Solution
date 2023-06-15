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
