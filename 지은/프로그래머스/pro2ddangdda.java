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