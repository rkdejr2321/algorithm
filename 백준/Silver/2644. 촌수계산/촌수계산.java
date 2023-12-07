import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int M;

    static int X;
    static int Y;

    static int answer = -1;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        X = Integer.parseInt(input[0]);
        Y = Integer.parseInt(input[1]);

        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        dfs(X, Y, 0);

        System.out.println(answer);
    }

    public static void dfs(int start, int end, int count) {
        if (start == Y) {
            answer = count;
            return;
        }

        visited[start][end] = true;
        visited[end][start] = true;

        for (int i = 1; i < N+1; i++) {
            if (!visited[start][i] && !visited[i][start] && map[start][i] == 1) {
                dfs(i, start , count+1);
            }
        }
    }
}
