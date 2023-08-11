class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letter = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        List<String> res = new ArrayList<>();
        if(digits.equals("")) return res;
        dfs(letter, digits, 0, res, new StringBuilder());
        return res;
    }

    public void dfs(String[] letter, String digits, int start,List<String> res, StringBuilder sb){
        if(sb.length() == digits.length()){
            res.add(new String(sb.toString()));
            return;
        }
        for(int i=0;i<letter[digits.charAt(start)-'0'].length();i++){
            sb.append(letter[digits.charAt(start)-'0'].charAt(i));
            dfs(letter, digits, start+1,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
