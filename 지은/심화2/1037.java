import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(min > cur) min = cur;
            if(max < cur) max = cur;
        }
        
        bw.write(String.valueOf(max*min));
        bw.flush();
        bw.close();
    }
}