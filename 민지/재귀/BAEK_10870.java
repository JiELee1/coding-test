import java.io.*;

public class BAEK_10870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = recursion(Integer.parseInt(br.readLine()));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static int recursion(int x){
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }
        return recursion(x-1) + recursion(x-2);
    }
}
