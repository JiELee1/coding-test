import java.io.*;
import java.util.*;

public class BEAK_20920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() >= M) { // M 이상 길이 단어만 저장
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        // 정렬을 위해 List로 담음
        List<String> words = new ArrayList<>(map.keySet());

        // 정렬 기준
        Collections.sort(words, new Comparator<String>() {
            // 음수 반환 (o1이 앞에 위치) -> 오름차순 정렬 원할 때 (작은값 -> 큰 값)
            // 양수 반환 (o2가 앞에 위치) -> 내림차순 정렬 원할 때 (큰 값 -> 작은 값)
            @Override
            public int compare(String o1, String o2){
                // 1. 자주 나오는 단어 순
                if(map.get(o1) != map.get(o2)){
                    return map.get(o2) - map.get(o1);
                }

                //2. 단어 길이가 긴 순
                if(o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }

                //3. 알파벳 사전 순
                return o1.compareTo(o2);
            }
        });

        for (String str : words) {
            sb.append(str).append("\n");
        }
        System.out.println(sb.toString());
    }
}
