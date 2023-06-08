class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map_s = new HashMap<>();
        HashMap<Character,Integer> map_p = new HashMap<>();

        for(char ph:p.toCharArray()){
            map_p.put(ph,map_p.getOrDefault(ph,0)+1);
        }

        int n = s.length();

        int left = 0, right = 0;

        int valid = 0;

        List<Integer> res = new ArrayList<>();

        while(right < n){

            char rh = s.charAt(right);
            map_s.put(rh, map_s.getOrDefault(rh, 0) + 1);
            if(map_p.containsKey(rh))
                if(map_s.get(rh).equals(map_p.get(rh))){
                    valid++;
                }
            right++;

            while(left<right && valid==map_p.size()){

                if(right-left==p.length()) res.add(left);
                char lh = s.charAt(left);
                if(map_p.containsKey(lh)){
                    if(map_s.get(lh).equals(map_p.get(lh))) valid--;
                    map_s.put(lh, map_s.getOrDefault(lh, 0) - 1);
                }
                left++;
            }
        }
        return res;

    }
}
