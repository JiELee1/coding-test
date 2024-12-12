import java.util.*;
import java.io.*;

class BEAK_15649 {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 초기화
        arr = new int[M];
        visit = new boolean[N + 1]; // 1부터 N까지 사용하므로 크기 N + 1

        // DFS 호출
        dfs(0);
        
        // 결과 출력
        System.out.println(sb.toString());
    }

    static void dfs(int depth) {
        // M개를 모두 선택한 경우 출력
        if (depth == M) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) { // 1부터 N까지 탐색
            if (!visit[i]) {
                visit[i] = true;       // 방문 표시
                arr[depth] = i;       // 현재 깊이에 숫자 저장
                dfs(depth + 1);       // 다음 깊이 탐색
                visit[i] = false;     // 방문 표시 해제
            }
        }
    }
}