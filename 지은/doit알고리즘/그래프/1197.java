import java.util.*;
import java.io.*;

public class Main {
    static Node[] graph;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new Node[m];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[i] = new Node(u,v,w);
        }

        Arrays.sort(graph);

        int res = 0;
        for(Node node : graph) {
            if(!check(node.a,node.b)) {
                res += node.w;
                union(node.a, node.b);
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();

    }
    static int find(int a) {
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    static boolean check(int a, int b) {
        return find(a) == find(b);
    }
}

class Node implements Comparable<Node>{
    int a,b,w;

    public Node(int a, int b, int w){
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}