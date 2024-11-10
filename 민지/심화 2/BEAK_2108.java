import java.io.*;
import java.util.*;

public class BEAK_2108 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        double sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            max = arr[i] > max ? arr[i] : max;
            min = arr[i] < min ? arr[i] : min;
        }
        Arrays.sort(arr);
        // 1. 산술평균, 소수점 이하 첫째 자리 반올림
        int avg = (int) Math.round(sum / N);
        // 2. 중앙값
        int median = arr[N/2];
        // 3. 최빈값
        // 3-1. 빈도수 계산
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        // 3-2. 최빈값 찾기        
        int maxFreq = 0;
        for(int value : map.values()){
            maxFreq = Math.max(maxFreq, value);
        }
        // 3-3. 최빈값에 해당하는 숫자들을 저장
        ArrayList<Integer> modes = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == maxFreq){
                modes.add(entry.getKey());
            }
        }
        // 3-4. 최빈값 여러 개 인 경우 두 번째로 작은 값을 출력 
        Collections.sort(modes);
        int mode = modes.size() > 1 ? modes.get(1) : modes.get(0);
        // 4. 범위, 최댓값과 최솟값의 차이
        int range = max - min;
        sb.append(avg).append("\n");
        sb.append(median).append("\n");
        sb.append(mode).append("\n");
        sb.append(range);
        System.out.println(sb.toString());
    }
}
