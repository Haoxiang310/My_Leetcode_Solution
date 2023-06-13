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
