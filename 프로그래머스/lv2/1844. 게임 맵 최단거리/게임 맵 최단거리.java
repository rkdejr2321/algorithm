import java.util.*;

class Solution {
    
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    int[][] visited;
    
    int answer = 0;
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;
        bfs(0,0,maps);
        answer = visited[maps.length - 1][maps[0].length - 1];
        
        if(answer == 0) {
            answer = -1;
        }
        return answer;
    }
    
    private void bfs(int i, int j, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            visited[i][j] = 1;
            
            //상하좌우 탐색
            for(int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                
                //범위를 벗어나지 않을 때
                if(x >= 0 && y >= 0 && x < maps.length && y < maps[0].length) {
                    //이동할 수 있고 방문하지 않았을 때
                    if(maps[x][y] == 1 && visited[x][y] == 0) {
                        visited[x][y] = visited[now[0]][now[1]] + 1;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
        
    }
}