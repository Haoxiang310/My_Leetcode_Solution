public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        String res = String.valueOf(root.val);
        if(root.left!=null) res += "," + serialize(root.left);
        if(root.right!=null) res += "," + serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode deserialize(Queue<String> q, int lowerBound, int upperBound){
        if(q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.parseInt(s);
        if(val < lowerBound || val > upperBound) return null;
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(q, lowerBound, val);
        root.right = deserialize(q, val, upperBound);
        return root;
    }
}
