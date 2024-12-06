import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //도시개수
        int M = Integer.parseInt(st.nextToken()); //도로개수
        int K = Integer.parseInt(st.nextToken()); //거리정보
        int X = Integer.parseInt(st.nextToken()); //출발도시번호

        graph = new ArrayList[N + 1];
        visit = new int[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
            visit[i] = -1;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        bfs(X);
        
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            if(visit[i] == K) {
                result.add(i);
            }
        }

        if(result.isEmpty()) bw.write("-1");
        else {
            for(int i : result) sb.append(i).append("\n");
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int a) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(a);
        visit[a]++;
        while(!queue.isEmpty()) {
            int cur = queue.remove();
            for(int i=0; i<graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if(visit[next] == -1) {
                    visit[next] = visit[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
}