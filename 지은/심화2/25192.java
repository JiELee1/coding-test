import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int answer = 0;
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            if(s.equals("ENTER")) {
                answer += set.size();
                set.clear();
                continue;
            }
            set.add(s);
        }
        answer += set.size();

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}