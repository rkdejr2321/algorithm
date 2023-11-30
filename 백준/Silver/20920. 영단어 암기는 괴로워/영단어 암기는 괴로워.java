import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            int compareByValue = Integer.compare(map.get(b), map.get(a));

            if (compareByValue != 0) {
                return compareByValue;
            }

            if (a.length() == b.length()) {
                return a.compareTo(b);
            }

            return Integer.compare(b.length(), a.length());
        });

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() >= M) {
                int count = map.getOrDefault(word, 0);
                count++;
                map.put(word, count);
            }
        }

        queue.addAll(map.keySet());


        while (!queue.isEmpty()) {
            bw.write(queue.poll());
            bw.newLine();
        }

        bw.flush();

    }
}
