import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.add(s);
        }
        
        int count = 0;
        while(pq.peek()<K) {
            if(pq.size()<2) return -1;
            int a = pq.remove();
            int b = pq.remove();
            
            pq.add(a+(b*2));
            count++;
        }
        
        return count;
    }
}