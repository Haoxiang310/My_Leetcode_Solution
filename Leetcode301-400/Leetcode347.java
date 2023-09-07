class Solution {
    Map<Integer, Integer> map = new HashMap<>(); //(freq,num)
    public int[] topKFrequent(int[] nums, int k) {

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[] arr = new int[map.size()];
        int j = 0;
        for(int n:map.keySet()){
            arr[j++] = n;
        }
        quickSelect(arr,0,arr.length-1,k);
        int[] res = new int[k];
        int z = 0;
        for(int i=arr.length-1;i>=arr.length - k;i--){
            res[z++] = arr[i];
        }
        return res;
    }

    public void quickSelect(int[] arr, int left, int right, int k){
        if(left == right) return;
        int index = partition(arr, left, right);
        if(index == arr.length - k) return;
        else if(index < arr.length - k) quickSelect(arr, index+1,right,k);
        else quickSelect(arr, left,index-1,k);
    }

    public int partition(int[] arr, int left, int right){
        int pivot = map.get(arr[right]);
        int l = left, r = right-1;
        while(l <= r){
            while(l <= r && map.get(arr[l]) < pivot) l++;
            while(l <= r && map.get(arr[r]) >= pivot) r--;
            if(l > r) break;
            swap(arr, l, r);
        }
        swap(arr, l, right);
        return l;
    }

    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
