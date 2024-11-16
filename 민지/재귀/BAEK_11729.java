import java.io.*;

public class BAEK_11729 {
    static StringBuilder sb = new StringBuilder();
    static int count = 0; // 이동 횟수 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 원판 개수 입력
        hanoi(N, 1, 2, 3); // 1번에서 3번으로 이동
        System.out.println(count); // 총 이동 횟수 출력
        System.out.print(sb.toString()); // 이동 순서 출력
    }

    public static void hanoi(int N, int start, int mid, int end) {
        if (N == 1) { // Base Case
            sb.append(start).append(" ").append(end).append("\n");
            count++; // 이동 횟수 증가
            return;
        }
        // 1. N-1개의 원판을 start에서 mid로 이동
        hanoi(N - 1, start, end, mid);
        // 2. 가장 큰 원판을 start에서 end로 이동
        sb.append(start).append(" ").append(end).append("\n");
        count++; // 이동 횟수 증가
        // 3. N-1개의 원판을 mid에서 end로 이동
        hanoi(N - 1, mid, start, end);
    }
}