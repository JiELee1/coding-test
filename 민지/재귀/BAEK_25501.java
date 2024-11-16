import java.io.*;

public class BAEK_25501 {
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            count=0;
            sb.append(isPalindrome(br.readLine().toCharArray())).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int isPalindrome(char[] ch){
        return recursion(ch,0,ch.length-1);
    }

    public static int recursion(char[] ch, int l, int r){
        count++;
        if(l>=r) return 1;
        else if(ch[l] != ch[r]) return 0;
        else return recursion(ch, l+1, r-1);
    }
}
