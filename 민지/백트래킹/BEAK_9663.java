import java.io.*;

//퀸이 배치될 수 없는 위치
//1. 같은 행, 2. 같은 열, 3. 대각선
public class BEAK_9663 {
    static int N;
    static int[] board; //각 행에 배치한 퀸의 열 위치
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //한 행에는 항상 하나의 퀸만 배치 (1차원 배열 쓰는 이유)
        board = new int[N];

        dfs(0); //0번 행부터터

        System.out.println(cnt);
    }

    static void dfs(int row){
        if(row == N){
            cnt++;
            return;
        }

        for(int col =0; col<N; col++){
            if (isPossible(row, col)){
                board[row] = col;
                dfs(row+1);
            }
        }
    }

    static boolean isPossible(int row, int col){
        for(int i=0;i<row;i++){
            // 같은 열에 퀸이 있거나 대각선 상에 퀸이 있는지 확인
            if(board[i] == col || Math.abs(board[i] - col) == Math.abs(i-row)){
                return false;
            }
        }
        return true;
    }
 }
