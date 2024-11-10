import java.io.*;
import java.util.*;

public class BEAK_26069 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> set = new HashSet<>();
        set.add("ChongChong"); //미리 ChongChong를 추가
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String nameA, nameB;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            nameA = st.nextToken();
            nameB = st.nextToken();
            if(set.contains(nameA) || set.contains(nameB)){ //미리 추가한 ChongChong를 포함하고 있다면 초기에 if문 들어올 것
                set.add(nameA);
                set.add(nameB);
            }
        }
        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }
    

}
