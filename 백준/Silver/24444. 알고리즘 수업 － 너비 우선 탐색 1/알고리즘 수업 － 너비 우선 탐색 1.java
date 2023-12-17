import java.io.*;
import java.util.*;

class Main {

    static int M;
    static int N;
    static int R;

    static int graph[];

    static boolean visited[];

    static int order = 0;

    static Queue<Integer> queue = new LinkedList<>();
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N+1; i++) {
            list.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 0; i < list.size(); i++)
            Collections.sort(list.get(i));


        visited[R] = true;
        queue.add(R);
        graph[R] = ++order;

        bfs();

        for (int i = 1; i <= N; i++) {
            System.out.println(graph[i]);
        }

    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int now = queue.poll();

            List<Integer> vertexes = list.get(now);

            for (int i = 0; i < vertexes.size(); i++) {
                int temp = vertexes.get(i);

                if (!visited[temp]) {
                    queue.add(temp);
                    visited[temp] = true;
                    graph[temp] = ++order;
                }
            }
        }
    }

}