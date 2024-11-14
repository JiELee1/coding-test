import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        bw.write(String.valueOf(recursive(n)));
        bw.flush();
        bw.close();
    }
    
    static long recursive(int n){
        if(n == 0 || n == 1) return 1;
        return n * recursive(n-1);
    }
}