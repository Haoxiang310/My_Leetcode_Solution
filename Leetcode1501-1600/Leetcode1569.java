class Solution {

    int MOD = (int)1e9+7;

    public int numOfWays(int[] nums) {
        List<Integer> t = new ArrayList<>();
        memo = new long[nums.length][nums.length];
        for(int num:nums) t.add(num);
        return (int)(totalWays(t)-1) % MOD;
    }

    public long totalWays(List<Integer> t){
        if(t.size()==0) return 1;
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        int head = t.get(0);
        for(int num:t){
            if(num!=head){
                if(num<head) l.add(num);
                else r.add(num);
            }

        }
        long leftComb = totalWays(l);
        long rightComb = totalWays(r);
        //total ways to combine the elements inside left subtree/right subtree
        //for example, if a subtree is 1->0, 1->2,then we have 2 ways [1,0,2] and [1,2,0]
        long insideComb = (leftComb * rightComb) % MOD;

        //total ways to combine left subtree and right subtree
        //since the relative position inside left subtree/ right subtree is determined by calculating the insideComb, here we only consider how to arrange the position between left subtree and right subtree
        //That is, we assume the relative position of left subtree/right subtree remains unchanged. Suppose we are arranging [1,2] of left subtree and [4,5] of right subtree. We need to make sure that the sequence of [1,2] and [4,5] do not change. We have 4 spaces right now and we select 2 spaces and put [1,2] into it. That will be nCk(4,2) ways. Then since the relative position of [4,5] is determined(by calculating rightComb), we only have 1 way to put [4,5] into the remaining 2 spaces
        long outsideComb = nCk(t.size()-1, l.size());
        return (insideComb * outsideComb) % MOD;
    }

    long[][] memo;
    public long nCk(int n, int k){
        if(n==k || k==0) return 1;
        if(memo[n][k]!=0) return memo[n][k];
        return memo[n][k] = (nCk(n-1,k-1) + nCk(n-1,k)) % MOD;
    }
}
