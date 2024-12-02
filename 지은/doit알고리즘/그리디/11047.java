import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=N-1; i>=0; i--) {
            int c = K/arr[i];
            if(K == 0) break;
            if(c>0) {
                count += c;
                K -= arr[i]*c;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }
}