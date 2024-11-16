import java.util.*;
import java.io.*;

public class Main {
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        d = new int[n+1];
        int result = topDown(n);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static int topDown(int i) {
        if(i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        }

        if(d[i] != 0) return d[i];
        d[i] = topDown(i - 1) + topDown(i - 2);
        return d[i];
    }

    static int BottomUp(int i) {
        for(int j = 0; j <= i; j++) {
            if(j == 0) d[j] = 0;
            else if (j == 1) d[j] = 1;
            else d[j] = d[j-1] + d[j-2];
        }
        return d[i];
    }
}