import java.io.*;

public class BAEK_4779 {
    static char[] ch;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr;
        while((inputStr = br.readLine()) != null){
            int N = Integer.parseInt(inputStr);
            int len = (int)Math.pow(3, N);
            ch = new char[len];
            
            sb = new StringBuilder();
            for(int i=0; i<len; i++){
                ch[i] ='-';
            }

            recursion(0, len);
            for(int i=0;i<ch.length;i++){
                sb.append(ch[i]);
            }
            System.out.println(sb.toString());
        }
    }

    public static void recursion(int start, int size){
        if(size == 1) return;

        int newSize = size/3;

        for(int i = start+newSize; i<start+2*newSize;i++) ch[i] = ' ';

        recursion(start, newSize);
        recursion(start+2*newSize, newSize);
    }
}
