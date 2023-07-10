class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int left = 0, min_start= 0, min_length = Integer.MAX_VALUE;
        int count = 0;
        //用count记录剩余的需要满足的t中的字符串的个数。如果为正，说明字符串s还有尚未满足的；如果为负，说明s窗口出现的字符串比t要求的还多，此时在删除了leftchar后需要判断map中leftchar的个数是否大于0，如果比0大了说明s窗口中该字符不满足要求，count--。count的定义是t中有几个字符已经在s中出现过，此处count对于t中重复元素依然会重复计算，这样可以通过count与t.length()的比较来判断当前窗口是否满足条件。
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c)>0){
                    count++;
                }
                map.put(c,map.get(c)-1);
            }
            while(count==t.length()){
                if(i-left+1<min_length){
                    min_start = left;
                    min_length = i-left+1;
                }
                char leftchar = s.charAt(left);
                if(map.containsKey(leftchar)){
                    map.put(leftchar,map.get(leftchar)+1);
                    if(map.get(leftchar)>0)
                        count--;
                }
                left++;
            }
        }
        if(min_length==Integer.MAX_VALUE) return "";
        return s.substring(min_start, min_start+min_length);
    }
}
