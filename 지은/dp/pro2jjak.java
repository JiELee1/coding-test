import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i<s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            char c = stack.peek();
            if(c == s.charAt(i)) {
                stack.poll();
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
        
    }
}