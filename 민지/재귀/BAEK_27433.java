import java.io.*;

public class BAEK_27433 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long result = recursion(Integer.parseInt(br.readLine()));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static long recursion(int x){
        if(x <= 0){
            return 1;
        }
        return x*recursion(x-1);
    }
}
