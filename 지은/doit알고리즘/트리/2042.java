import java.util.*;
import java.io.*;

public class Main {
    static long[] arr;
    static long last = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int k = (int) Math.ceil(Math.log(n) / Math.log(2));
        int size = (int) (Math.pow(2,k)*2);
        arr = new long[size];

        int start = (int) Math.pow(2,k);
        for(int i = 0; i < n; i++) {
            arr[start+i] = Long.parseLong(br.readLine());
        }

        //초기
        for(int i = size-1; i>1; i--) {
            arr[i/2] += arr[i];
        }


        for(int i = 0; i < m+count; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                //b를 c로 바꾸기
                changeArr(b+start-1,c);
            } else {
                //b에서 c까지 합
                last = 0;
                sb.append(arrSum(b+start-1,(int)(c+start-1))).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void changeArr(int b, long c) {
        long gap = c-arr[b];
        arr[b] = c;
        while(b>0) {
            b/=2;
            arr[b]+=gap;
        }
    }

    static long arrSum(int start, int end) {
        if(start == end) return arr[start]+last;
        else if(start > end) return last;

        if(start % 2 == 1) last += arr[start];
        if(end % 2 == 0) last += arr[end];

        start = (start + 1) / 2;
        end = (end - 1) / 2;
        return arrSum(start, end);
    }


}
