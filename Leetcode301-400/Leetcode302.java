class Solution {
    public int minArea(char[][] image, int x, int y) {
        int left1 = 0, left2 = y;
        int right1 = y, right2 = image[0].length - 1;
        int m = image.length;
        while(left1 <= right1){
            boolean foundOne = false;
            int mid1 = left1 + (-left1 + right1)/2;
            for(int i=0;i<m;i++){
                if(image[i][mid1] == '1') {
                    right1 = mid1 - 1;
                    foundOne = true;
                }
            }
            if(!foundOne) left1 = mid1 + 1;
        }
        while(left2 <= right2){
            boolean foundOne = false;
            int mid2 = left2 + (right2 - left2)/2;
            for(int i=0;i<m;i++){
                if(image[i][mid2] == '1'){
                    left2 = mid2 + 1;
                    foundOne = true;
                }
            }
            if(!foundOne) right2 = mid2 - 1;
        }
        int l1 = 0, r1 = x;
        int l2 = x, r2 = m - 1;
        while(l1 <= r1){
            boolean foundOne = false;
            int m1 = l1 + (r1 - l1)/2;
            for(int i=left1;i<left2;i++){
                if(image[m1][i] == '1') {
                    r1 = m1 - 1;
                    foundOne = true;
                }
            }
            if(!foundOne) l1 = m1 + 1;
        }
        while(l2 <= r2){
            int m2 = l2 + (r2 - l2)/2;
            boolean foundOne = false;
            for(int i=left1;i < left2;i++){
                if(image[m2][i] == '1') {
                    l2 = m2 + 1;
                    foundOne = true;
                }
            }
            if(!foundOne) r2 = m2 - 1;
        }
        return (left2 - left1) * (l2 - l1);
    }
}
