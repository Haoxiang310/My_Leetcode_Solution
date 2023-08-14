//O(N^2) prefixSum Solution
class Solution {
    public int subarraySum(int[] nums, int k) {
        int N = nums.length;
        int[] prefixSum = new int[N+1];
        for(int i=1;i<prefixSum.length;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        int res = 0;
        for(int i=0;i<prefixSum.length;i++){
            for(int j=i+1;j<prefixSum.length;j++){
                if(prefixSum[j] - prefixSum[i] == k) res++;
            }
        }
        return res;
    }
}

//O(N) Solution
//same as 2 sum, use hashmap to record all the cases that has been seen
//when we judge prefixSum[i] - prefixSum[j] == k(0<=j<i), we use map to record all the cases of prefixSum[j]
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        map.put(0,1); //(prefixSum,freq)
        for(int num: nums){
            sum += num;
            if(map.containsKey(sum - k)) res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
