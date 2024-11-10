import java.io.*;

public class BEAK_10872 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = solution(N);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
    
    public static int solution(int n){
        if(n<=1){ // n이 0일 때 함수 호출되면 solution(n-1)이 계속 재귀 호출되어 Stack OverFlow 발생, 따라서 조건을 == 가 아닌 <= 로 해야함
            return 1;
        }
        
        return n*solution(n-1);
    }
}
