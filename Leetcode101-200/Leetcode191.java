public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1, res = 0;
        for(int i=0;i<32;i++){
            if(((mask<<i) & n) != 0) res++;
        }
        return res;
    }
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n!=0){
            cnt++;
            //最右边一位1置为0
            n &= (n-1);
        }
        return cnt;
    }
}
