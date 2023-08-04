class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> l = new ArrayList<>();
        dfs(root,l);
        return String.join(",", l);
    }

    public void dfs(Node root,List<String> l){
        if(root == null) return;
        l.add(String.valueOf(root.val));
        l.add(String.valueOf(root.children.size()));
        for(Node child:root.children){
            dfs(child, l);
        }
        return;
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.equals("")) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(q);
    }

    public Node helper(Queue<String> q){
        Node root = new Node(Integer.valueOf(q.poll()),new ArrayList<>());
        int sz = Integer.valueOf(q.poll());
        for(int i=0;i<sz;i++){
            root.children.add(helper(q));
        }
        return root;
    }
}
