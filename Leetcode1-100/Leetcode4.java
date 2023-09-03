class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int M = nums1.length, N = nums2.length;
        if(M > N) return findMedianSortedArrays(nums2,nums1);
        int left = 0, right = M;
        while(left <= right){
            int mid = left + (right-left)/2;
            int small1 = mid <= 0 ? Integer.MIN_VALUE : nums1[mid-1], large1 = mid >= M ? Integer.MAX_VALUE : nums1[mid];
            int small2 = (M+N)/2-mid <= 0 ? Integer.MIN_VALUE : nums2[(M+N)/2-mid-1],large2 = (M+N)/2-mid >= N ? Integer.MAX_VALUE : nums2[(M+N)/2-mid];
            if(small1 <= large2 && small2 <= large1){
                if((M+N) % 2 == 0) return (double)(Math.max(small1,small2) + Math.min(large1,large2))/2;
                else return (double)(Math.min(large1,large2));
            }
            else if(small1 > large2) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
