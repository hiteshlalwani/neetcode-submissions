class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n < 3) return n;
        int p1 = 1, p2 = 2;
        int res = 0;
        for (int i = 3; i <= n; ++i) {
            res = p1 + p2;
            p1 = p2;
            p2 = res;
        }        
        return res;
    }
}
