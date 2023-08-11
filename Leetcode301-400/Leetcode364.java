//BFS Solution
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>(nestedList);
        int res = 0, levelSum = 0, level = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0;i<sz;i++){
                NestedInteger curr = q.poll();
                //levelSum stores the total sum of single integer from level 1 to currlevel
                if(curr.isInteger()) levelSum += curr.getInteger();
                //break the curr(list) to several NestedInteger
                else q.addAll(curr.getList());
            }
            res += levelSum;
        }
        return res;
    }
}

//DFS Solution
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        getMaxDepth(nestedList, 1);
        return dfs(nestedList, 1);
    }

    int maxDepth = 1;
    public void getMaxDepth(List<NestedInteger> nestedList, int depth){
        for(NestedInteger ni : nestedList){
            if(ni.isInteger() || ni.getList().size() == 0){
                maxDepth = Math.max(maxDepth, depth);
            }
            else getMaxDepth(ni.getList(), depth+1);
        }
        return;
    }

    public int dfs(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()) sum += ni.getInteger() * (maxDepth - depth + 1);
            else sum += dfs(ni.getList(), depth + 1);
        }
        return sum;
    }
}
