class Solution {
    public int longestMountain(int[] arr) {
        int res = 0;
        int start = 0;
        while(start < arr.length){
            int end = start;
            if(end < arr.length - 1 && arr[end] < arr[end+1]){
                while(end < arr.length - 1 && arr[end] < arr[end+1]) end++;
                while(end < arr.length - 1 && arr[end] > arr[end+1]){
                    end++;
                    res = Math.max(res, end - start + 1);
                }
            }
            start = Math.max(start+1,end);
        }
        return res;
    }
}
