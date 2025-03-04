class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int i = 0;
        while(str.length() < t*m) {
            str += Integer.toString(i,n);
            i++;
        }
        
        for(int j = p-1; j<t*m; j += m) {
            answer += str.charAt(j);
        }
        return answer.toUpperCase();
    }
}