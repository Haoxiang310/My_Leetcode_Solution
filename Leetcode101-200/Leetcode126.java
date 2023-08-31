class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //bfs建立只含最短路径的图
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> minSteps = new HashMap<>();
        Map<String, List<String>> parents = new HashMap<>();
        Set<String> wordlist =  new HashSet<>(wordList);
        parents.put(beginWord, new ArrayList<>());
        if(!wordlist.contains(endWord)) return res;
        q.offer(beginWord);
        minSteps.put(beginWord,1);
        wordlist.remove(beginWord);
        boolean isFound = false;
        int step = 1;
        while(!q.isEmpty() && !isFound){
            int sz = q.size();
            for(int i = 0;i<sz;i++){
                String curr = q.poll();
                for(int j = 0;j<curr.length();j++){
                    StringBuilder sb = new StringBuilder(curr);
                    for(char c = 'a';c<='z';c++){
                        if(c == curr.charAt(j)) continue;
                        sb.setCharAt(j,c);
                        String next = sb.toString();
                        if(wordlist.contains(next)){
                            if(next.equals(endWord)){
                                parents.computeIfAbsent(next, x -> new ArrayList<>()).add(curr);
                                isFound = true;
                            }
                            else{
                                if(step < minSteps.getOrDefault(next,Integer.MAX_VALUE)){
                                    parents.computeIfAbsent(next, x -> new ArrayList<>()).add(curr);
                                    //防止同一个元素重复入队
                                    if(!minSteps.containsKey(next)) q.offer(next);
                                    minSteps.put(next, step+1);
                                }
                            }      
                        }
                    }
                }
            }
            step++;
        }

        //dfs遍历所有最短路径
        dfs(beginWord,parents,endWord,new ArrayList<>(List.of(endWord)));
        
        return res;
    }

    public void dfs(String beginWord, Map<String, List<String>> parents, String cur, List<String> path){
        if(cur.equals(beginWord)){
            res.add(new ArrayList<>(path));
        }
        for(String parent:parents.getOrDefault(cur,new ArrayList<>())){
            path.add(0,parent);
            dfs(beginWord,parents,parent,path);
            path.remove(0);
        }
    }
}
