class Solution {

    Set<String> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        int M = board.length, N = board[0].length;
        for(String word: words) trie.addWord(word);
        boolean[][] visited = new boolean[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                dfs(i,j,board,trie,visited,"");
            }
        }
        return new ArrayList<>(set);
    }

    public void dfs(int x, int y, char[][] board, Trie trie, boolean[][] visited, String word){
        int M = board.length, N = board[0].length;
        if( x < 0 || x >= M || y < 0 || y >= N || visited[x][y]) return;
        word += board[x][y];
        if(!trie.startsWith(word)) return;
        if(trie.search(word)) {
            set.add(word);
        }
        visited[x][y] = true;
        dfs(x+1,y,board,trie,visited,word);
        dfs(x-1,y,board,trie,visited,word);
        dfs(x,y+1,board,trie,visited,word);
        dfs(x,y-1,board,trie,visited,word);
        visited[x][y] = false;
    }
}

class TrieNode {

    boolean isWord;
    
    TrieNode[] children;

    public TrieNode(){

        children = new TrieNode[26];

    }
}

class Trie {

    TrieNode root;

    public Trie(){

        root = new TrieNode();

    }

    public void addWord(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a'] == null) node.children[c-'a'] = new TrieNode();
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
        }
        return node.isWord;
    }

     public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}
