class Solution {
    public int strStr(String haystack, String needle) {
        int L = needle.length();
        int R = 256;
        long RL = 1;
        long Q = 1658598167;
        for(int i=1;i<=L-1;i++){
            RL = (RL*R)%Q;
        }
        long needleHash = 0;
        for(int i=0;i<needle.length();i++){
            needleHash = (needleHash*R+needle.charAt(i))%Q;
        }
        long windowHash = 0;
        int left = 0, right = 0;
        while(right<haystack.length()){
            windowHash = ((windowHash*R)%Q+haystack.charAt(right))%Q;
            right++;
            if(right-left==L){
                if(windowHash == needleHash){
                    if(needle.equals(haystack.substring(left,right))){
                        return left;
                    }
                }
                windowHash = (windowHash-haystack.charAt(left)*RL%Q + Q) % Q;
                left++;
            }
        }
        return -1;
    }
}
