class Solution {
    public String breakPalindrome(String palindrome) {
        StringBuilder sb = new StringBuilder(palindrome);
        if(palindrome.length() == 1) return "";
        for(int i=0;i<palindrome.length() / 2;i++){
            if(sb.charAt(i)!='a') {
                sb.replace(i,i+1,"a");
                return sb.toString();
            }
        }
        sb.replace(sb.length()-1,sb.length(),"b");
        return sb.toString();
    }
}
