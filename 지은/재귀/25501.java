import java.util.*;
import java.io.*;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            count = 0;
            sb.append(recursion(s, 0, s.length()-1)).append(" ").append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int recursion(String s, int n, int k) {
        count++;
        if(n >= k) return 1;
        else if(s.charAt(n) != s.charAt(k)) return 0;
        else return recursion(s, n+1, k-1);
    }
}