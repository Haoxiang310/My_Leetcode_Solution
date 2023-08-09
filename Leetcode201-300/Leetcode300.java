class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i] > sub.get(sub.size()-1)) sub.add(nums[i]);
            else{
                int index = binarySearch(sub, nums[i]);
                sub.set(index, nums[i]);
            }
        }
        //final result may not be the valid LIS, but the length remains the same
        //since we only replacing the subseq element without adding extra, the length will not exceed the correct result
        return sub.size();
    }

    public int binarySearch(List<Integer> sub, int curr){
        int left = 0, right = sub.size();
        while(left < right){
            int mid = left + (right - left)/2;
            //same element replace
            if(curr > sub.get(mid)) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
