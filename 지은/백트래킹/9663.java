import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        //index : 열, 값 : 헹
        arr = new int[n];

        recursion(0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    static void recursion(int col) {
        if(col == n) {
            count++;
            return;
        }
        for(int i=0; i<n; i++) {
            arr[col] = i;
            if(check(col)) {
                recursion(col+1);
            }
        }
    }

    static boolean check(int col) {
        //이전 열에 채운 퀸이랑 동선이 겹치는 지 확인하는 것이기 때문에 col까지 반복
        for(int i=0; i<col; i++) {
            //같은 행에 있는지 체크
            if(arr[i] == arr[col]) {
                return false;
            }

            //열의 차와 행의 차가 같을 경우 대각선에 놓여있는 거임
            if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}