import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String chat = br.readLine();

            if (chat.equals("ENTER")) {
                answer += map.size();
                map.clear();
            } else {
                if (!map.containsKey(chat)) {
                    map.put(chat, 1);
                }
            }
        }

        answer += map.size();

        System.out.println(answer);

    }
}
