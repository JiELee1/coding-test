import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String str = Integer.toString(n,k);
        long prime = 0;
        int answer = 0;
        for(int i=0; i<str.length(); i++) {
            char cur = str.charAt(i);
            if(cur == '0') {
                if(isPrime(prime)) answer++;
                prime = 0;
            }
            else prime = prime*10 + (cur-'0');    
        }
        return isPrime(prime) ? ++answer : answer;
    }
    
    boolean isPrime(long p) {
        if(p == 0 || p == 1) return false;
        for(int i = 2; i<=Math.sqrt(p); i++) {
            if(p % i == 0) return false;
        }
        return true;
    }
}