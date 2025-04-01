import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        int min = Math.min(a,b);
        int max = Math.max(a,b);
        
        while(true) {
            answer++;
            if(min % 2 == 1 && max == min + 1)
                break;
            min = oper(min);
            max = oper(max);
        }

        return answer;
    }
    
    public int oper(int n) {
        if(n % 2 == 0) return n/2;
        else return n/2+1;
    }
}