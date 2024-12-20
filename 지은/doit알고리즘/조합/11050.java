import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] c = new int[n+1][n+1];
        for(int i = 0; i<c.length; i++) {
            c[i][i] = 1;
            c[i][1] = i;
            c[i][0] = 1;
        }
        
        for(int i = 1; i<c.length; i++) {
            for(int j =1; j<i; j++) {
                c[i][j] = c[i-1][j]+c[i-1][j-1];
            }
        }
        
        bw.write(String.valueOf(c[n][k]));
        bw.flush();
        bw.close();
    }
}