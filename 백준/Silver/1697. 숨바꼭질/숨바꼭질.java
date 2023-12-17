import java.io.*;
import java.util.*;

class Main {

    static int time = 0;
    static int[] map = new int[100001];
    static int N;
    static int K;

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue.add(N);
        map[N] = 0;

        if (N == K) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                System.out.println(map[now]);
                return;
            }

            if (now - 1 >= 0 && map[now - 1] == 0) {
                queue.add(now - 1);
                map[now - 1] =  map[now] + 1;
            }

            if (now + 1 <= 100000 && map[now + 1] == 0) {
                queue.add(now + 1);
                map[now + 1] = map[now]  +1;
            }

            if (now * 2 <= 100000 && map[now * 2] == 0) {
                queue.add(now * 2);
                map[now * 2] = map[now] + 1;
            }
        }
        System.out.println(-1);
    }
}