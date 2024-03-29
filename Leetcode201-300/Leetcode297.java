public class Codec {

    StringBuilder sb;
    public void traverse(TreeNode root){
        if(root==null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        traverse(root.left);
        traverse(root.right);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        traverse(root);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        LinkedList<String> roots = new LinkedList<>();
        for(String s:arr){
            roots.add(s);
        }
        return construct(roots);
    }

    public TreeNode construct(LinkedList<String> roots){
        if(roots.size()==0) return null;
        String first = roots.removeFirst();
        if(first.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = construct(roots);
        root.right = construct(roots);
        return root;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "#";
        StringBuilder sb = new StringBuilder();
        return sb.append(root.val).append(",").append(serialize(root.left)).append(",").append(serialize(root.right)).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(q);
    }

    public TreeNode helper(Queue<String> q){
        String s = q.poll();
        if(s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }
}

