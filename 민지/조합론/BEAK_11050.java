import java.io.*;
import java.util.*;

public class BEAK_11050 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int result = solution(N)/(solution(N-M)*solution(M));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static int solution(int n){
        if(n<=1){
            return 1;
        }
        
        return n*solution(n-1);
    }
}
