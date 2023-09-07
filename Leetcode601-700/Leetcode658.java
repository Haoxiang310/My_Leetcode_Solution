class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == x){
                left = right = mid;
                break;
            }
            else if(arr[mid] > x){
                right = mid - 1;
            }
            else left = mid + 1;
        }

        int l = left-1, r = left;
        List<Integer> res = new ArrayList<>();
        while(k > 0){
            if(l < 0) r++;
            else if(r>=arr.length) l--;
            else if(Math.abs(arr[l]-x) <= Math.abs(arr[r]-x)) l--;
            else r++;
            k--;
        }
        for(int z=l+1;z<r;z++) res.add(arr[z]);
        return res;
    }
}
