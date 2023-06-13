class Solution {

    int count;
    long[] temp;
    int lower;
    int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        //use long in case Integer overflow
        long[] prefixSum = new long[nums.length+1];
        temp = new long[prefixSum.length];
        int sum = 0;
        //calculate prefixSum
        for(int i=0;i<prefixSum.length-1;i++){
            prefixSum[i+1] = nums[i]+prefixSum[i];
        }
        sort(prefixSum,0,prefixSum.length-1);
        return count;
    }

    public void sort(long[] prefixSum, int lo, int hi){
        if(lo==hi) return;
        int mid = lo + (hi-lo)/2;
        sort(prefixSum,lo,mid);
        sort(prefixSum,mid+1,hi);
        merge(prefixSum,lo,mid,hi);
    }

    public void merge(long[] prefixSum, int lo, int mid, int hi){
        int p1 = lo, p2 = mid+1, p = lo;
        for(int i=lo;i<=hi;i++){
            temp[i]=prefixSum[i];
        }

        int start = mid + 1, end = mid + 1;
        //sliding window
        for(int j = lo;j<=mid;j++){
            while(start<=hi && prefixSum[start]-prefixSum[j]<lower) start++;
            while(end<=hi && prefixSum[end]-prefixSum[j]<=upper) end++;
            count+=(end-start);
        }

        for(;p<=hi;p++){
            if(p1==mid+1) prefixSum[p]=temp[p2++];
            else if(p2==hi+1) prefixSum[p]=temp[p1++];
            else if(temp[p1]<temp[p2]) prefixSum[p]=temp[p1++];
            else prefixSum[p]=temp[p2++];
        }
    } 
}
