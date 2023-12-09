import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        long answer = 0;
        ArrayList<Gem> arrayList = new ArrayList<>();
        ArrayList<Integer> bags = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Gem gem = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            arrayList.add(gem);
        }

        Collections.sort(arrayList, ((o1, o2) -> o1.m - o2.m));

        for (int i = 0; i < K; i++) {
            int bag = Integer.parseInt(br.readLine());

            bags.add(bag);
        }

        Collections.sort(bags);

        PriorityQueue<Gem> pq = new PriorityQueue<>(((o1, o2) -> o2.v - o1.v));

        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && bags.get(i) >= arrayList.get(j).m) {
                pq.add(arrayList.get(j));
                j++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll().v;
            }
        }

        System.out.println(answer);

    }

    public static class Gem {
        int m;
        int v;

        public Gem(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
