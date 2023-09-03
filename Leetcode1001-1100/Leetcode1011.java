class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while(left <= right){
            int mid = left + (right-left)/2;
            long c = calc(weights,mid);
            if(c > days) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public long calc(int[] weights, int capacity){
        long res = 0;
        int cur = 0,cnt = 0;
        while(cnt < weights.length){
            cur += weights[cnt];
            if(cur > capacity){
                cnt--;
                res++;
                cur = 0;
            }
            cnt++;
        }
        return res + 1;
    }
}
