class Solution {
    int[] temp;
    int count;
    public int reversePairs(int[] nums){
        temp = new int[nums.length];
        sort(0,nums.length-1,nums);
        return count;
    }

    public void sort(int lo, int hi, int[] nums){
        if(lo==hi) return;
        int mid = lo + (hi-lo)/2;
        sort(lo,mid,nums);
        sort(mid+1,hi,nums);
        merge(lo,mid,hi,nums);
    }

    public void merge(int lo, int mid, int hi, int[] nums){
        int p1 = lo, p2 = mid+1, p = lo;
        for(int i=lo;i<=hi;i++){
            temp[i]=nums[i];
        }
        int end = mid+1;
        for(int i=lo;i<=mid;i++){
            while(end<=hi && (long)nums[i]>(long)2*nums[end]){
                end++;
            }
            count+=end-(mid+1);
        }
        for(;p<=hi;p++){
            if(p1==mid+1) nums[p]=temp[p2++];
            else if(p2==hi+1) nums[p]=temp[p1++];
            else if(temp[p1]>temp[p2]){
                nums[p]=temp[p2++];
            }
            else nums[p]=temp[p1++];
        }
    }
}
