import java.util.*;

class Solution {
    
    static int M;
    static int N;
    
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    static String[][] maze;
    static int[] start = new int[2];
    static int[] lever = new int[2];
    static int[] exit = new int[2];
    

    public static int solution(String[] maps) {

        N = maps.length;
        M = maps[0].length();

        maze = new String[N][M];

        for (int i = 0; i < N; i++) {
            String[] map = maps[i].split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = map[j];

                if (map[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }

                if (map[j].equals("L")) {
                    lever[0] = i;
                    lever[1] = j;
                }

                if (map[j].equals("E")) {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }

        int findLever = dfs(start, "L");
        int findExit = dfs(lever, "E");

        if (findExit == -1 || findLever == -1) {
            return -1;
        } else {
            return findExit + findLever;
        }


    }

    public static int dfs(int[] start, String target) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start[0], start[1], 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];

            if (maze[x][y].equals(target)) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (!maze[nx][ny].equals("X") && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, count + 1});
                }
            }

        }

        return -1;
    }
}