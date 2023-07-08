class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            int startIndex = i-k+1;
            if(!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]) q.pollLast();
            q.offerLast(i);
            if(startIndex>=0) res[startIndex] = nums[q.peekFirst()];
        }
        return res;
    }
}
