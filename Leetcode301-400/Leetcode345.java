class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int l = 0, r = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while(l < r){
            while(l < r && !set.contains(sb.charAt(l))) l++;
            while(l < r && !set.contains(sb.charAt(r))) r--;
            char temp = sb.charAt(l);
            sb.setCharAt(l, s.charAt(r));
            sb.setCharAt(r, temp);
            l++;r--;
        }
        return sb.toString();
    }
}
