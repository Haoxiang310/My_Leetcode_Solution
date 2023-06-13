class Pair{
    int val;
    int index;
    Pair(int val, int index){
        this.val = val;
        this.index = index;
    }
}
class Solution {

    Pair[] temp;
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        temp = new Pair[nums.length];
        count = new int[nums.length];
        Pair[] arr = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = new Pair(nums[i],i);
        }
        sort(arr,0,nums.length-1);
        for(int c:count){
            res.add(c);
        }
        return res;
    }

    public void sort(Pair[] arr, int lo, int hi){
        if(lo==hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public void merge(Pair[] arr, int lo, int mid, int hi){
        int p1 = lo, p2 = mid + 1, p = lo;
        for(int i=lo;i<=hi;i++){
            temp[i]=arr[i];
        }
        for(;p<=hi;p++){
            if(p1 == mid + 1) arr[p] = temp[p2++];
            else if(p2 == hi+1) {
                arr[p] = temp[p1++];
                count[arr[p].index]+=p2-mid-1;
            }
            else if(temp[p1].val>temp[p2].val) arr[p] = temp[p2++];
            else {
                arr[p] = temp[p1++];
                count[arr[p].index]+=p2-mid-1;
            }
        }
    }
}
