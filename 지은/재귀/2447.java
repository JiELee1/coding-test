import java.util.*;
import java.io.*;

public class Main {

    static String[][] arr = null;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];

        star(0, 0, N);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                bw.write(arr[i][j] != null ? arr[i][j] : " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(int x, int y, int size) {
        if(size == 1){
            arr[x][y] = "*";
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!(i==1 && j==1))
                    star(x + i*size/3, y + j*size/3, size/3);
            }
        }
    }
}