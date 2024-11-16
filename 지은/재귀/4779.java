import java.util.*;
import java.io.*;

public class Main {

    static char[] lineArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);

            int len = (int) Math.pow(3, N);

            lineArr = new char[len];
            Arrays.fill(lineArr, '-');

            divide(0, len);

            for(int i = 0; i < lineArr.length; i++){
                bw.write(lineArr[i]);
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();

    }

    static void divide(int start, int length) {
        if(length <= 1){
            return;
        }
        int newLength = length/3;

        for(int i = start+newLength; i < start+newLength*2; i++){
            lineArr[i] = ' ';
        }
        divide(start, newLength);
        divide(start+newLength*2, newLength);
    }
}