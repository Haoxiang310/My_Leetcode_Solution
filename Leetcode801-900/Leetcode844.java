class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> deq_s = new ArrayDeque<>();
        Deque<Character> deq_t = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '#') deq_s.pollLast();
            else deq_s.offerLast(c);
        }
        for(int j=0;j<t.length();j++){
            char c = t.charAt(j);
            if(c == '#') deq_t.pollLast();
            else deq_t.offerLast(c);
        }
        while(!deq_s.isEmpty() && !deq_t.isEmpty()){
            char cs = deq_s.pollFirst();
            char ct = deq_t.pollFirst();
            if(cs != ct) return false;
        }
        return deq_s.isEmpty() && deq_t.isEmpty();
    }
}
