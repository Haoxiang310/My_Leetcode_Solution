//single direction bfs
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // List<String> temp = getNextAdjacentList("hot",wordList);
        // for(String s:temp) System.out.println(s);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        Set<String> visited = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                String curr = q.poll();
                if(curr.equals(endWord)) return step;
                for(int j=0;j<beginWord.length();j++){
                    StringBuilder sb = new StringBuilder(curr);
                    for(int k=0;k<26;k++){
                        sb.setCharAt(j,(char)('a'+k));
                        if(set.contains(sb.toString())) {
                            q.add(sb.toString());
                            set.remove(sb.toString());
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

}

//double direction bfs
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // List<String> temp = getNextAdjacentList("hot",wordList);
        // for(String s:temp) System.out.println(s);
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        Set<String> wordlist = new HashSet<>(wordList);
        s1.add(beginWord);
        s2.add(endWord);
        if(!wordlist.contains(endWord)) return 0;
        int step = 1;
        while(!s1.isEmpty() && !s2.isEmpty()){
            HashSet<String> s = new HashSet<>();
            for(String curr:s1){
                wordlist.remove(curr);
                for(int j=0;j<beginWord.length();j++){
                    StringBuilder sb = new StringBuilder(curr);
                    for(int k=0;k<26;k++){
                        sb.setCharAt(j,(char)('a'+k));
                        if(s2.contains(sb.toString())) return step+1;
                        if(wordlist.contains(sb.toString())){
                            s.add(sb.toString());
                        }
                    }
                }
            }
            step++;
            if(s.size() > s2.size()){
                s1 = s2;
                s2 = s;
            }
            else s1 = s;
        }
        return 0;
    }

}
