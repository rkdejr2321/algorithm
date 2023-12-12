import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int digit = 1;

            for (int j = input.length() - 1; j >= 0; j--) {
                String s = String.valueOf(input.charAt(j));
                int value = map.getOrDefault(s, 0);
                value += digit;

                map.put(s, value);
                digit *= 10;
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int max = 9;

        for (String key : keySet) {
            int num = map.get(key);

            answer += num * max;
            max--;
        }

        System.out.println(answer);
    }
}
