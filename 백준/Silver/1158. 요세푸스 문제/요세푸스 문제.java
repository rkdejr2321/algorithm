import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>(IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList()));
        ArrayList<Integer> arrayList = new ArrayList<>();

        int order = 1;

        while (!queue.isEmpty()) {
            if (order == K) {
                arrayList.add(queue.poll());
                order = 1;
            } else {
                queue.add(queue.poll());
                order++;
            }
        }


        StringBuilder builder = new StringBuilder();
        builder.append("<");

        for (int num: arrayList) {
            builder.append(num).append(", ");
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);

        builder.append(">");

        System.out.println(builder);
    }
}