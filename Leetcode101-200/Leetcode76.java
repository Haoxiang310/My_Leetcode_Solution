class Solution {

    

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map_s = new HashMap<>();
        HashMap<Character, Integer> map_t = new HashMap<>();
        for(char c:t.toCharArray()){
            map_t.put(c,map_t.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        int n = s.length();
        int valid = 0;
        int start = 0;
        while(right < n){
            char c = s.charAt(right);
            if(map_t.containsKey(c)){
                map_s.put(c,map_s.getOrDefault(c,0)+1);
                if(map_s.get(c).equals(map_t.get(c))) valid++;
            }
            right++;

            while(left<right && valid == map_t.size()){
                if(right-left<len){
                    start = left;
                    len = right-left;
                }
                char tc = s.charAt(left);
                
                if(map_t.containsKey(tc)){
                    map_s.put(tc,map_s.getOrDefault(tc,0)-1);
                    if(map_s.get(tc)<(map_t.get(tc))) valid--;
                }                
                left++;
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);

    }

}
