import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int answer;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        for (int height = 0; height <= max; height++) {
            visited = new boolean[N][N];
            int safeArea = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > height) {
                        safeArea++;
                        dfs(i, j, height);
                    }
                }
            }
            answer = Math.max(answer, safeArea);
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int num) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            //탐색 범위 초과
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            
            if (visited[nx][ny] || map[nx][ny] <= num) {
                continue;
            }

            if (map[nx][ny] > num) {
                dfs(nx, ny, num);
            }
        }
    }
}
