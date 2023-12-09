import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int repeatNum;
        int answer = 0;

        queue.add(A);
        map.put(A, 1);

        int start = A;
        while (true) {
            String forward = String.valueOf(start);
            int backward = 0;

            for (int i = 0; i < forward.length(); i++) {
                int num = Character.getNumericValue(forward.charAt(i));
                backward += Math.pow(num, P);
            }

            if (map.containsKey(backward)) {
                repeatNum = backward;
                break;
            }

            map.put(backward, 1);
            queue.add(backward);
            start = backward;
        }

        while (queue.peek() != repeatNum) {
            queue.poll();
            answer++;
        }

        System.out.println(answer);
    }


}
