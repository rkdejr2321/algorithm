import java.io.*;
import java.util.*;

class Main {

    static int order = 0;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean visited[];

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 0; i <= N; i++) {
            List<Integer> integers = list.get(i);

            Collections.sort(integers);
        }

        visited[R] = true;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            int order = map.getOrDefault(i, 0);

            System.out.println(order);
        }

    }

    public static void dfs(int start) {

        map.put(start, order + 1);

        List<Integer> integers = list.get(start);

        for (int num : integers) {
            if (!visited[num]) {
                visited[num] = true;
                order++;
                dfs(num);
            }
        }
    }

}