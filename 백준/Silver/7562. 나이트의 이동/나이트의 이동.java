import java.io.*;
import java.util.*;

class Main {

    static int[] dx = new int[] {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] dy = new int[] {1, -1, 1, -1, 2, 2, -2, -2};

    static int I;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] map;
        int[][] visited;
        int[] start;
        int[] end;

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());

            map = new int[I][I];
            visited = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            start = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine()," ");
            end = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            bfs(map, visited,start, end);

        }
    }

    public static void bfs(int[][] map, int[][] visited ,int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);


        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            if (x == end[0] && y == end[1]) {
                System.out.println(visited[x][y]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >=0 && nx < I && ny >= 0 && ny < I && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }

}