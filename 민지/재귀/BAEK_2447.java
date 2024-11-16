import java.io.*;

public class BAEK_2447{
    static String[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        recursive(0,0,N);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                //null인 공간은 " "로 변경
                bw.write(arr[i][j]!=null ? arr[i][j] : " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void recursive(int x, int y, int size){
        // 재귀함수를 사용하여 size가 1 이 되면 * 저장
        if(size == 1) {
            arr[x][y] = "*";
            return;
        }
        // size 1이 될 때 까지 3*3 크기로 분할
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                //i와 j가 1일 때는 빈공간으로 만들 것임으로 건너뛰기
                //x와 y는 값을 계속 유지하며 재귀함수 호출
                if(!(i==1 && j==1)) recursive(x+i*size/3, y+j*size/3, size/3);
            }
        }
    }
}