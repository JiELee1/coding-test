import java.io.*;
import java.util.StringTokenizer;

public class BAK_1010 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            dp = new int[M+1][N+1]; 
            sb.append(solution(M,N)).append("\n");
        }
        System.out.println(sb);
    }

    public static int solution(int n, int r) {
        if(r > n) return 0;
        if(r == 0 || n == r) return 1;
        
        if(dp[n][r] > 0) {
            return dp[n][r];
        }
        
        return dp[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
    }
}