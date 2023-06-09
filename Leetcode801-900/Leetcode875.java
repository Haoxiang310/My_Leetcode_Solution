class Solution {

    public long calculateHour(int[] piles, int k){

        int hour = 0;
        for(int i=0;i<piles.length;i++){
            hour+=piles[i]/k;
            if(piles[i]%k>0) hour++;
        }
        return hour;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = 1000000000+1;

        while(left<right){
            int mid = left + (right - left) / 2;
            if((calculateHour(piles,mid))>h){
                left = mid+1;
            }
            else if((calculateHour(piles,mid))<h){
                right = mid;
            }
            else if(calculateHour(piles,mid)==h){
                right = mid;
            }
        }

        return left;

    }
}
