import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static int[] d;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        d = new int[n+1];
        parent = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1,0);
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lca(a,b)).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int i, int depth) {
        visited[i] = true;
        d[i] = depth;
        for(int v : graph[i]) {
            if(!visited[v]) {
                parent[v] = i;
                dfs(v, depth+1);
            }
        }
    }

    static int lca(int a, int b) {
        while (d[a] != d[b]) {
            if(d[a] > d[b]) a = parent[a];
            else b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
