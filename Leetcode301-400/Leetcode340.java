class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size() > k){
                char cLeft = s.charAt(left);
                map.put(cLeft, map.get(cLeft)-1);
                if(map.get(cLeft)==0) map.remove(cLeft);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
