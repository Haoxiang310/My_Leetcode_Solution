class Solution {
    public boolean isValid(String s) {
        if(s==null) return true;
        if(s.length()%2==1) return false;
        char currentChar = '#';
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');
        for(int i=0;i<s.length();i++){
            currentChar = s.charAt(i);
            if(currentChar=='(' || currentChar=='{' || currentChar=='['){
                stack.push(currentChar);
            }
            else if(currentChar==')' || currentChar=='}' || currentChar==']'){
                if(stack.isEmpty()) return false;
                if(hashMap.get(currentChar) != stack.pop()) return false;
                else continue;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
