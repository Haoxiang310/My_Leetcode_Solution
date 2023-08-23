class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0;i<time.length;i++) time[i] %= 60;
        for(int i=0;i<time.length;i++){
            int cur = time[i];
            if(cur == 0 && map.containsKey(cur)) ans += map.get(cur);
            if(map.containsKey(60 - cur)){
                ans += map.get(60 - cur);
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return ans;
    }
}
