import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n+1];

        dfs(0, "");

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void dfs(int idx, String s) {
        if(s.length() == m*2) sb.append(s).append("\n");
        if(idx == n) return;

        for(int i=1; i<=n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(idx+1, s+i+" ");
                visit[i] = false;
            }
        }
    }
}