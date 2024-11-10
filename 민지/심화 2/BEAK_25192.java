import java.io.*;
import java.util.*;

public class BEAK_25192 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> set = new HashSet<>(); 
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i<N; i++){
            String nickName = br.readLine();
            if(nickName.equals("ENTER")){
               set.clear(); 
            }else{
                if(set.contains(nickName)) continue;
                set.add(nickName);
                answer++;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        
    }
}
