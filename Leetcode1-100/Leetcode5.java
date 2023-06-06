class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0 || s.length()==1) return s;
        String res = "";
        for(int i=0;i<s.length();i++){
            String s1 = expand(s,i,i);
            String s2 = expand(s,i,i+1);
            res = res.length()>s1.length()?res:s1;
            res = res.length()>s2.length()?res:s2;
        }
        return res;
    }

    public String expand(String s, int l, int r){
        String res = "";
        while(l>=0 && r<s.length()){
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            else break;
        }
        return s.substring(l+1,r);
    }
}