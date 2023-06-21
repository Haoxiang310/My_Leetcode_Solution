/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> originToClone = new HashMap<>();
    public Node cloneGraph(Node node) {
        traverse(node);
        return originToClone.get(node);
    }
    public void traverse(Node node){
        if(node==null) return;

        if(originToClone.containsKey(node)) return;
        Node cloneNode = new Node(node.val,new ArrayList<>());
        originToClone.put(node,cloneNode);

        for(Node neighbor:node.neighbors){
            
            traverse(neighbor);
            Node cloneNeighbor = originToClone.get(neighbor);
            cloneNode.neighbors.add(cloneNeighbor);
        }
        return;
    }
}
