import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            if(s.length()>=m) map.put(s, map.getOrDefault(s,0)+1);
        }

        List<String> key = new ArrayList<>(map.keySet());
        key.sort((o1, o2) -> {
            if(map.get(o1).equals(map.get(o2))) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return map.get(o2)-map.get(o1);
        });

        for(String k : key) {
            bw.write(k+"\n");
        }
        bw.flush();
        bw.close();
    }
}