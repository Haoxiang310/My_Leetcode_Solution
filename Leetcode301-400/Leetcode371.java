class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int carry = a & b; //进位
            a = a ^ b; //保留两个数相加没有进位的结果（第一次是a+b,后面是a+b没有进位的结果+进位结果）
            b = carry << 1;
        }
        return a;
    }
}
