class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieSet set = new TrieSet<>();
        for(String s:dictionary){
            set.add(s);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        int i=0;
        for(String word:words){
            String pre = set.shortestPrefixOf(word);
            if(!pre.isEmpty())   sb.append(pre);
            else sb.append(word);
            if(i!=words.length-1) sb.append(' ');
            i++;
        }
        return sb.toString();
    }
}

class TrieSet<V>{
    private final TrieMap<Object> map = new TrieMap<>();

    /***** 增 *****/

    // 在集合中添加元素 key
    public void add(String key) {
        map.put(key, new Object());
    }

    /***** 删 *****/

    // 从集合中删除元素 key
    public void remove(String key) {
        map.remove(key);
    }

    /***** 查 *****/

    // 判断元素 key 是否存在集合中
    public boolean contains(String key) {
        return map.containsKey(key);
    }

    // 在集合中寻找 query 的最短前缀
    public String shortestPrefixOf(String query) {
        return map.shortestPrefixOf(query);
    }

    // 在集合中寻找 query 的最长前缀
    public String longestPrefixOf(String query) {
        return map.longestPrefixOf(query);
    }

    // 在集合中搜索前缀为 prefix 的所有元素
    public List<String> keysWithPrefix(String prefix) {
        return map.keysWithPrefix(prefix);
    }

    // 判断集合中是否存在前缀为 prefix 的元素
    public boolean hasKeyWithPrefix(String prefix) {
        return map.hasKeyWithPrefix(prefix);
    }

    // 通配符 . 匹配任意字符，返回集合中匹配 pattern 的所有元素
    public List<String> keysWithPattern(String pattern) {
        return map.keysWithPattern(pattern);
    }

    // 通配符 . 匹配任意字符，判断集合中是否存在匹配 pattern 的元素
    public boolean hasKeyWithPattern(String pattern) {
        return map.hasKeyWithPattern(pattern);
    }

    // 返回集合中元素的个数
    public int size() {
        return map.getSize();
    }
}
class TrieMap<V> {

    private static final int R = 256;

    private int size = 0;

    public int getSize(){
        return size;
    }

    private TrieNode<V> root = null;

    public static class TrieNode<V>{
        V val = null;
        TrieNode<V>[] children = new TrieNode[R];
    }

    //Put Methods:
    public void put(String key, V val){
        if(!containsKey(key)){
            size++;
        }
        root=put(root,key,val,0);
    }

    public TrieNode<V> put(TrieNode<V> node, String key, V val, int i){
        if(node==null) node = new TrieNode<V>();
        if(i==key.length()) {
            node.val=val;
            return node;
        }
        char c = key.charAt(i);
        node.children[c]=put(node.children[c],key,val,i+1);
        return node;
    }
    
    //Remove Methods:
    public void remove(String key){
        if(!containsKey(key)) return;
        size--;
        root=remove(root,key,0);
    }

    //To decide whether a node need to be deleted, it must satisfy (1)(2) simultaneously:
    //(1)node.val==null
    //(2)all node.children==null
    public TrieNode<V> remove(TrieNode<V> node, String key, int i){
        if(node==null) return null;
        if(i==key.length()){
            node.val=null;
        }
        else{
            char c = key.charAt(i);
            node.children[c]=remove(node.children[c],key,i+1);
        } 
        if(node.val!=null){
            return node;
        }
        for(char c=0;c<R;c++){
            if(node.children[c]!=null) return node;
        }
        return null;
    }

    //Search Methods:
    //Only detect if String key exist as a prefix. If String key is a key, then in addition, key.val must not be null
    public TrieNode<V> getNode(TrieNode<V> node, String key){
        TrieNode<V> p = node;
        for(int i=0;i<key.length();i++){
           if(p==null) return null;
           char c = key.charAt(i);
           p = p.children[c];
        }
        return p;
    }

    //search specific value of a key. If key doesn't exist, return null.
    public V get(String key){
        TrieNode<V> node = getNode(root,key);

        //key does not exist if node==null or node.val==null
        if(node==null || node.val==null) return null;
        return node.val;
    }

    public boolean containsKey(String key){
        return get(key)!=null;
    }

    public boolean hasKeyWithPrefix(String prefix){
        return getNode(root,prefix)!=null;
    }

    //find shortest prefix of String query among all the keys
    public String shortestPrefixOf(String query){
        TrieNode<V> p = root;
        for(int i=0;i<query.length();i++){
            if(p==null) return "";
            if(p.val!=null) return query.substring(0,i);
            char c = query.charAt(i);
            p=p.children[c];
        }
        //for loop only detect the branches, but not the last node. Extra test is needed as below, if the query itself is the key.
        if(p!=null && p.val!=null) return query;
        return "";
    }


    public String longestPrefixOf(String query){
        TrieNode<V> p = root;
        int maxLen = 0;
        for(int i=0;i<query.length();i++){
            if(p==null) break;
            if(p.val!=null) maxLen = i;
            char c = query.charAt(i);
            p = p.children[c];
        }
        if(p!=null && p.val!=null) return query;
        return query.substring(0,maxLen);
    }

    //get all keys with prefix prefix
    public List<String> keysWithPrefix(String prefix){
        TrieNode<V> node = getNode(root, prefix);
        List<String> res = new LinkedList<>();
        if(node==null) return res;
        traverse(node, new StringBuilder(prefix),res);
        return res;
    }

    //dfs starting from TrieNode node
    public void traverse(TrieNode<V> node, StringBuilder path, List<String> res){
        if(node==null){
            return;
        }
        if(node.val!=null){
            res.add(path.toString());
        }
        for(char c=0;c<R;c++){
            path.append(c);
            traverse(node.children[c],path,res);
            path.deleteCharAt(path.length()-1);
        }
    }


    public List<String> keysWithPattern(String pattern){
        List<String> res = new LinkedList<>();
        traverse(root,new StringBuilder(),pattern,0,res);
        return res;
    }

    //get all keys that match the pattern
    public void traverse(TrieNode<V> node, StringBuilder path, String pattern, int i, List<String> res){
        if(node==null) return;
        if(i==pattern.length()){
            if(node.val!=null){
                res.add(path.toString());
            }

        }
        char c = pattern.charAt(i);
        if(c!='.'){
            path.append(c);
            traverse(node.children[c],path,pattern,i+1,res);
            path.deleteCharAt(path.length()-1);
        }
        else{
            for(char j = 0;j<R;j++){
                path.append(j);
                traverse(node.children[j],path,pattern,i+1,res);
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    public boolean hasKeyWithPattern(String pattern){
        return hasKeyWithPattern(root,pattern,0);
    }

    public boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int i){
        if(node==null) return false;
        if(i==pattern.length()) return node.val!=null;
        char c = pattern.charAt(i);
        if(c=='.'){
            for(char j=0;j<R;j++){
                if(hasKeyWithPattern(node.children[j],pattern,i+1)) return true;
            }
        }
        else return hasKeyWithPattern(node.children[c],pattern,i+1);
        return false;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
