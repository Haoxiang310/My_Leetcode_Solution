class Solution {
    
    public String countAndSay(int n) {
        if(n==1) return "1";
        
        String s = countAndSay(n-1);
        int l = s.length();
        int start = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        while(end<l){
            if(s.charAt(end)==s.charAt(start)){
                end++; 
                if(end!=l) continue;
            }
                
            int num = end-start;
                int tm =Character.getNumericValue(s.charAt(start));
                char tmp = (char)(tm+'0');
                sb.append((char)(num+'0'));
                sb.append(tmp);
                start = end;
        }
        return sb.toString();
    }
}
