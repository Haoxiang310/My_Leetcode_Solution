class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        if(s1.length()>s2.length()) return false;

        for(char c:s1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        int left= 0, right = 0;
        int valid = 0;
        while(right<s2.length()){
            char ch = s2.charAt(right);
            if(map1.containsKey(ch)){
                map2.put(ch,map2.getOrDefault(ch,0)+1);
                if(map2.get(ch).equals(map1.get(ch))) valid++;
            }
            right++;
            while(left<right && right-left==s1.length()){
                if(valid == map1.size()) return true;
                char th = s2.charAt(left);
                if(map1.containsKey(th)){
                    if(map2.get(th).equals((map1.get(th)))) valid--;
                    map2.put(th,map2.getOrDefault(th,0)-1);
                }
                left++;
            }
        }
        return false;
    }
}
