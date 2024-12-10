import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            arr[b]++;
        }

        sort();

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void sort() {
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=1; i< graph.length; i++) {
            if(arr[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for(int i=0; i<graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                arr[next]--;
                if(arr[next] == 0) queue.add(next);
            }
        }
    }
}