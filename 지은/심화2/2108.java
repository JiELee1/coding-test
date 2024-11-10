import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int hap = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            hap+=a;
            map.put(a,map.getOrDefault(a,0)+1);
        }
        Arrays.sort(arr);
        sb.append(Math.round((double)hap/n)).append("\n");
        sb.append(arr[n/2]).append("\n");

        int max = Collections.max(map.values());
        int count = 0;
        for(int key : map.keySet()) {
            if(map.get(key) == max) {
                count++;
            }
        }

        List<Integer> k = new ArrayList<>(map.keySet());
        k.sort((o1, o2) -> {
            if(map.get(o1).equals(map.get(o2))) {
                return o1 - o2;
            }
            return map.get(o2) - map.get(o1);
        });

        if(count > 1) sb.append(k.get(1)).append("\n");
        else sb.append(k.get(0)).append("\n");

        sb.append(arr[n-1]-arr[0]).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}