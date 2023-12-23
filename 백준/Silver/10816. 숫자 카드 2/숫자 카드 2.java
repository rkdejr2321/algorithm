import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        Map<Integer, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            int count = map.getOrDefault(input, 0);

            map.put(input, count + 1);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            sb.append(map.getOrDefault(num, 0)).append(" ");
        }

        String answer = sb.toString().strip();

        System.out.println(answer);
    }

}