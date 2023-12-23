import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        Set<String> set = new HashSet<>();

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            if (set.contains(input)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}