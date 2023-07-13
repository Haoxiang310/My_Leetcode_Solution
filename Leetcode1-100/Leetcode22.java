class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n,new StringBuilder(),0,0);
        return res;
    }

    public void dfs(int n, StringBuilder sb, int openNum, int closeNum){
        if(openNum + closeNum == 2 * n){
            res.add(new String(sb.toString()));
            return;
        }
        //左括号没到一半都可以加
        if(openNum < n){
            sb.append("(");
            dfs(n,sb,openNum+1,closeNum);
            sb.deleteCharAt(sb.length()-1);
        }
        //只有右括号数量比左括号少时才能加右括号
        if(closeNum < openNum){
            sb.append(")");
            dfs(n,sb,openNum,closeNum+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
