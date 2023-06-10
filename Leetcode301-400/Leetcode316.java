class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();
        boolean[] instack = new boolean[256];
        int[] count = new int[256];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]--;
            if(instack[s.charAt(i)]) continue;
            
            while(!stk.isEmpty() && stk.peek()>s.charAt(i)){
                if(count[stk.peek()]>0){
                    instack[stk.pop()]=false;
                }
                else break;
            }

            stk.push(s.charAt(i));
            instack[s.charAt(i)]=true;

        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
