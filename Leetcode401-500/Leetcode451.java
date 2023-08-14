class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Character>[] bucket = new List[s.length()+1];
        for(char c: map.keySet()){
            int freq = map.get(c);
            if(bucket[freq]==null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(char c:bucket[i]){
                    for(int j=0;j<i;j++)
                        sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
