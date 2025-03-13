import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 1;
        int cur = 0;
        
        while(cur < order.length) {
            if(stack.isEmpty() || stack.peek() < order[cur]) {
                stack.push(i);
                i++;
            } else if(stack.peek() == order[cur]) {
                stack.pop();
                answer++;
                cur++;
            } else break;
        }
        return answer;
    }
}