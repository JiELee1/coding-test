import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int total = 0;
        int cur = 0;
        int idxCount = 0;
        while(cur < progresses.length) {
            total += oper(progresses[cur] + (speeds[cur]*total), speeds[cur]);
            int count = 0;
            for(int i = cur; i<progresses.length; i++) {
                if(progresses[i] + (speeds[i]*total) < 100) {
                    cur = i;
                    break;
                }
                count++;
            }
            answer.add(count);
            idxCount += count;
            if(idxCount == progresses.length) break;
        }

        return answer.stream().mapToInt(s -> i).toArray();
    }
    
    int oper(int progress, int speed) {
        int day = 0;
        while(progress < 100) {
            progress += speed;
            day++;
        }
        return day;
    }
    
}