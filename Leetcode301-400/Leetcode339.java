//DFS Solution
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    public int dfs(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()) sum += depth*ni.getInteger();
            else sum += dfs(ni.getList(), depth+1);
        }
        return sum;
    }
}

//BFS Solution
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>(nestedList);
        int sum = 0, step = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                NestedInteger curr = q.poll();
                if(curr.isInteger()) sum += curr.getInteger() * step;
                else{
                    q.addAll(curr.getList());
                }
            }
            step++;
        }
        return sum;
    }
}
