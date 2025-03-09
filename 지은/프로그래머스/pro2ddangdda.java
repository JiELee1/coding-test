//dp
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length+1][4];
        for(int i=1; i<=land.length; i++) {
            for(int j=0; j<4; j++) { //이전꺼   
                for(int k=0; k<4; k++) {
                    if(j != k) {
                        dp[i][k] = Math.max(dp[i-1][j] + land[i-1][k], dp[i][k]);
                    }
                    answer = Math.max(answer, dp[i][k]);
                }
            }

        }
        return answer;
    }

}



//시간초과
class Solution {
    int result = 0;
    int solution(int[][] land) {
        recursive(-1,0,0,land);
        return result;
    }
    
    void recursive(int cur, int count, int score, int[][] land) {
        if(count == land.length) {
            result = Math.max(result,score);
            return;
        }
        
        for(int i=0; i<4; i++) {
            if(i != cur) {
                recursive(i, count+1, score+land[count][i], land);
            }
        }
    }
}