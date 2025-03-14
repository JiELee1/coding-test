import java.io.*;
import java.util.*;

public class BEAK_15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);

        System.out.println(sb.toString());
    }

    static void dfs(int start, int depth){
        if(depth == M){
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<=N;i++){
            arr[depth] = i; 
            dfs(i, depth + 1);
        }
    }
 }
