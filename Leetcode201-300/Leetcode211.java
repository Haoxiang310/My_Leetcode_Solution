class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a'] == null) node.children[c-'a'] = new TrieNode();
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        return helper(0, word, node);
    }

    public boolean helper(int pos, String word, TrieNode node){
        if(pos == word.length()) return node.isWord;
        char c = word.charAt(pos);
        if(c != '.'){
            return node.children[c-'a'] != null && helper(pos+1, word, node.children[c-'a']);
        }
        for(int i=0;i<26;i++){
            if(node.children[i] != null && helper(pos + 1, word, node.children[i])) 
                return true;
        }
        return false;
    }
}

class TrieNode {
    boolean isWord; 
    TrieNode[] children;

    public TrieNode(){
        children = new TrieNode[26];
    }
}
