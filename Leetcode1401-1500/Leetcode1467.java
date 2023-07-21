class Solution {
    double[][] memo;
    public double getProbability(int[] balls) {
        int sum = Arrays.stream(balls).sum();
        memo = new double[sum+1][sum+1];
        double validCount = dfs(0,0,0,0,balls,0);
        double totalCount = nCk(sum,sum/2);

        return validCount / totalCount;
    }

    //count1, count2 refers to the distinct colors in box1 and box2
    //sum1, sum2 refers to the total number of balls in box1 and box2
    //index refers to the variety of the ball we currently consider
    public double dfs(int count1, int count2, int sum1, int sum2, int[] balls, int index){
        //when distinct colors and sum are both same, we return 1, representing it is a valid count
        if(index == balls.length) return (count1 == count2 && sum1 == sum2) ? 1 : 0;
        double res = 0;
        //we put all the balls with color ball[index] into box1
        res += dfs(count1+1,count2,sum1+balls[index],sum2,balls,index+1);
        //we put all the balls with color ball[index] into box2
        res += dfs(count1,count2+1,sum1,sum2+balls[index],balls,index+1);
        //we separate the balls of color index into 2 boxs
        //note that the balls with same color are also distinct, so we need to choose i balls among balls[index] number of balls in color index, that's why we calculate nCk(balls[index],i)
        for(int i=1;i<balls[index];i++){
            res += nCk(balls[index],i) * dfs(count1+1,count2+1,sum1+i,sum2+balls[index]-i,balls,index+1);
        }
        return res;
    }

    public double nCk(int n, int k){
        if(n==k || k==0) return 1;
        if(memo[n][k]!=0) return memo[n][k];
        return memo[n][k] = nCk(n-1,k-1) + nCk(n-1,k);
    }
}
