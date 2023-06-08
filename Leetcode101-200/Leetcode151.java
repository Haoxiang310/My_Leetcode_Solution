class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trimSpace(s);
        System.out.println(sb.toString());
        reverse(sb,0,sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }

    public StringBuilder trimSpace(String s){
        int left = 0;
        int right = s.length()-1;
        StringBuilder sb = new StringBuilder();
        while(left<=right && s.charAt(left)==' ') left++;
        while(left<=right && s.charAt(right)==' ') right--;

        while(left<=right){
            char c = s.charAt(left);
            if(c!=' ') sb.append(c);
            else if(sb.charAt(sb.length()-1)!=' ') sb.append(' ');
            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right){
        while(left<right){
            char tmp = sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,tmp);
            left++;
            right--;
        }
        return;
    }

    public void reverseEachWord(StringBuilder sb){
        int n = sb.length();
        int start = 0, end = 0;
        while(start<n){
            while(end<n && sb.charAt(end)!=' '){
                end++;
            }
            reverse(sb,start,end-1);
            start = ++end;
        }
    }

}
