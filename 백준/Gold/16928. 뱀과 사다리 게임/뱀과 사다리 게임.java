import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static Map<Integer, Integer> ladderMap = new HashMap<>();
    static Map<Integer, Integer> snakeMap = new HashMap();
    static int[] visited = new int[101];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladderMap.put(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snakeMap.put(u, v);
        }

        bfs();
        System.out.println(visited[100]);
    }

    public static void bfs() {
        queue.add(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100) {
                    continue;
                }

                // 사다리 또는 뱀을 이용한 이동
                if (ladderMap.containsKey(next)) {
                    next = ladderMap.get(next);
                } else if (snakeMap.containsKey(next)) {
                    next = snakeMap.get(next);
                }

                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
