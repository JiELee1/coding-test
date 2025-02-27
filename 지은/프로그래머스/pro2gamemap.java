import java.util.*;

class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int[][] visit;
    int xMax, yMax;
    public int solution(int[][] maps) {
        xMax = maps[0].length;
        yMax = maps.length;
        visit = new int[yMax][xMax];
        for(int i =0; i<maps.length; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }
        visit[0][0] = 1;
        dfs(maps, 0, 0);
        return visit[yMax-1][xMax-1] == Integer.MAX_VALUE ? -1 : visit[yMax-1][xMax-1];
    }
    
    void dfs(int[][] maps, int x, int y) {
        if(x == xMax-1 && y == yMax-1) return;
        
        for(int i = 0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(nx>=0 && ny>=0 && nx<xMax && ny<yMax) {
                if(maps[ny][nx] == 1) {
                    if((visit[ny][nx] = Math.min(visit[ny][nx], visit[y][x] + 1)) == visit[y][x] + 1) {
                        dfs(maps, nx, ny);
                    }
                }
            }
        }
    }
}