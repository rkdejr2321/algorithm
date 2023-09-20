import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int N;
    int M;
    boolean visited[][];
    ArrayList<Integer> answer = new ArrayList<>();

    public int[] solution(String[] maps) {
        
        
        N = maps.length;
        M = maps[0].length();

        char[][] map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] != 'X') {
                    bfs(i, j , map);
                }
            }
        }

        Collections.sort(answer);

        if(answer.size() == 0) {
            answer.add(-1);
        }

        return answer.stream().mapToInt(Integer -> Integer).toArray();
    }
    
    public void bfs(int i, int j, char[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        int sum = 0;
        visited[i][j] = true;
        while(!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            sum += map[nowX][nowY] - '0';

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if(x >= 0 && x < N  && y >=0 && y < M) {
                    if(!visited[x][y] && map[x][y] != 'X') {
                        queue.add(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        answer.add(sum);
    }

}