class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int n = s.length();
        int res = 0;
        while(right < n){
            char rh = s.charAt(right);
            map.put(rh,map.getOrDefault(rh,0)+1);

            right++;
            while(left<right && map.get(rh)>1){

                char lh = s.charAt(left);

                map.put(lh,map.getOrDefault(lh,0)-1);
                left++;
            }
            res=Math.max(right-left,res);
        }
        return res;
    }
}
