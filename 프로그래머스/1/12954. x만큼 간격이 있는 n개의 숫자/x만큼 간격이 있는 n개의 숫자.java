class Solution {
    public long[] solution(long x, int n) {
        long[] ans = new long[n];
        for(int i = 0; i<n; i++) {
            ans[i] = x + (i * x);
        }
        return ans;
    }
}