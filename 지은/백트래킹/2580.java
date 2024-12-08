import java.util.*;
import java.io.*;

public class Main {
    static int[][] sudoku = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //스도쿠 입력
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeSudoku(0,0);

    }

    static void makeSudoku(int row, int col) throws IOException {
        if(col == 9) {
            makeSudoku(row+1, 0);
            return;
        }

        if(row == 9) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            // 경우의 수가 많을 경우 하나를 출력했다면 바로 시스템 종료
            System.exit(0);
        }

        if(sudoku[row][col] == 0) {
            for(int i=1; i<=9; i++) {
                if(check(row, col, i)) {
                    sudoku[row][col] = i;
                    makeSudoku(row, col+1);
                }
            }
            //넣을 값이 없으면 잘못된것이므로 0으로 초기화 후 재귀종료
            sudoku[row][col] = 0;
            return;
        }

        makeSudoku(row, col+1);
    }

    static boolean check(int row, int col, int value) {

        //가로 세로 체크
        for(int i=0; i<9; i++) {
            if (sudoku[row][i] == value) return false;
            if (sudoku[i][col] == value) return false;
        }

        //3x3 체크
        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;
        for(int i=rowStart; i<rowStart+3; i++) {
            for(int j=colStart; j<colStart+3; j++) {
                if (sudoku[i][j] == value) return false;
            }
        }

        return true;
    }
}