import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        PriorityQueue<Long> queue = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cardCount = 0;
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        while (cardCount < M) {
            long sum = 0;
            for (int i = 0; i < 2; i++) {
                sum += queue.poll();
            }

            for (int i = 0; i < 2; i++) {
                queue.add(sum);
            }

            cardCount++;
        }

        long answer = 0;

        while (!queue.isEmpty()) {
            answer += queue.poll();
        }

        System.out.println(answer);
    }
}
