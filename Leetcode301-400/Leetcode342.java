class Solution {
    public boolean isPowerOfFour(int n) {
        //2的乘方是10,1000,100000,10000000,4的乘方是01，0100，01000000
        //通过与1010101010101010做&运算即可区分
        return n > 0 && ((n & (n-1)) == 0) && ((n & 0xaaaaaaaa) == 0);
    }
}
