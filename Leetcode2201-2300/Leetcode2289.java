class Solution {
        public int totalSteps(int[] A) {
        int n = A.length, res = 0, j = -1;
        int dp[] = new int[n], stack[] = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (j >= 0 && A[i] > A[stack[j]]) {
                dp[i] = Math.max(++dp[i], dp[stack[j--]]);
                res = Math.max(res, dp[i]);
            }
            stack[++j] = i;
        }
        return res;
    }
}
