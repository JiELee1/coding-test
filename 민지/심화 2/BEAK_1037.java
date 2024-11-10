import java.io.*;
import java.util.StringTokenizer;

public class BEAK_1037 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(st.nextToken());
            min = x < min ? x : min;  
            max = x > max ? x : max;
        }
        bw.write(String.valueOf(min * max));
        bw.flush();
        bw.close();
    }
}
