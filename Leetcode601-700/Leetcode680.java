class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++; r--;
            }
            else return checkPalindrome(s, l, r-1) || checkPalindrome(s, l+1, r);
        }
        return true;
    }

    public boolean checkPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}
