class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int left = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            while(!maxQ.isEmpty() && nums[i] > nums[maxQ.peekLast()]) maxQ.pollLast();
            while(!minQ.isEmpty() && nums[i] < nums[minQ.peekLast()]) minQ.pollLast();

            maxQ.offerLast(i);
            minQ.offerLast(i);
            while(!maxQ.isEmpty() && !minQ.isEmpty() && nums[maxQ.peekFirst()]-nums[minQ.peekFirst()] > limit){
                if(maxQ.peekFirst() == left) maxQ.pollFirst();
                if(minQ.peekFirst() == left) minQ.pollFirst();
                left++;
            }
            res = Math.max(res, i - left+1);
        }
        return res;
    }
}
