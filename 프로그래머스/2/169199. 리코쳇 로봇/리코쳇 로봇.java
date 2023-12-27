import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] visited;
    static String[][] map;
    static int[] start = new int[2];
    static Queue<int[]> queue = new LinkedList<>();
    
    public int solution(String[] board) {
        int answer = 0;
        
        N = board.length;
        M = board[0].length();
        
        visited = new int[N][M];
        map = new String[N][M];
        
        for (int i = 0; i < N; i++) {
            String[] temp = board[i].split("");
            
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[j];
                if (temp[j].equals("R")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        queue.add(start);
        
        answer = bfs();
        
        return answer;
    }
    
    public static int bfs() {
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            if (map[x][y].equals("G")) {
                return visited[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M ) {
                    continue;
                }

                while (nx >= 0 && nx < N && ny >=0 && ny < M && !map[nx][ny].equals("D")) {
                    nx += dx[i];
                    ny += dy[i];
                }

                nx -= dx[i];
                ny -= dy[i];

                if (visited[nx][ny] != 0 || (x == nx && y == ny)) {
                    continue;
                }

                visited[nx][ny] = visited[x][y] + 1;
                queue.add(new int[] {nx, ny});
            }

        }

        return -1;

    }
}