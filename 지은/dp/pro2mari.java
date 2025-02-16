class Solution {
    public long solution(int n) {
        long[] res = new long[n+1];
        
        if(n == 1) return 1;
        res[1] = 1;
        res[2] = 2;
        
        for(int i=3; i<=n; i++) {
            res[i] = (res[i-1]+res[i-2])%1234567;
        }
        
        return res[n];
    }
}