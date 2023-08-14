class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, k, 0, points.length-1);
        return Arrays.copyOfRange(points, points.length-k, points.length);
    }

    public void quickSelect(int[][] points, int k, int left, int right){
        int index = partition(points, left, right);
        if(index == points.length - k) return;
        else if(index > points.length - k) quickSelect(points, k, left, index-1);
        else quickSelect(points, k, index+1, right); 
    }

    public int partition(int[][] points, int left, int right){
        int[] pivot = points[right];
        int l = left, r = right-1;
        while(l <= r){
            while(l <= r && compare(points[l], pivot)>0) l++;
            while(l <= r && compare(points[r], pivot)<=0) r--;
            if(l >= r) break;
            swap(points,l,r);
        }
        swap(points,l,right);
        return l;
    }

    public void swap(int[][] points, int left, int right){
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }

    public int compare(int[] p1, int[] p2){
        return p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1];
    }
}
