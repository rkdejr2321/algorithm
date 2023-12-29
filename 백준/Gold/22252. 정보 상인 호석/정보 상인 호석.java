import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        long answer = 0;

        Map<String, List<Integer>> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                String name = st.nextToken();
                List<Integer> list;
                int amount = Integer.parseInt(st.nextToken());

                if (map.containsKey(name)) {
                    list = map.get(name);
                } else {
                    list = new ArrayList<>();
                }

                for (int j = 0; j < amount; j++) {
                    list.add(Integer.parseInt(st.nextToken()));
                }

                list.sort(Collections.reverseOrder());

                map.put(name, list);
            }

            if (num == 2) {
                String name = st.nextToken();
                List<Integer> infos = map.get(name);

                int count = Integer.parseInt(st.nextToken());

                if (!map.containsKey(name)) {
                    continue;
                }
                if (count >= infos.size()) {
                    answer += infos.stream().mapToInt(Integer::intValue).sum();
                    infos.clear();
                } else {
                    for (int k = 0; k < count; k++) {
                        answer += infos.get(0);
                        infos.remove(0);
                    }
                }

                map.put(name, infos);
            }
        }

        System.out.println(answer);
    }
}

