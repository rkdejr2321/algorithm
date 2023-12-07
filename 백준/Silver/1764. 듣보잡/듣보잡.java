import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map.put(input, 1);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (map.containsKey(input)) {
                list.add(input);
            }
        }
        
        Collections.sort(list);
        
        bw.write(String.valueOf(list.size()));
        bw.newLine();

        for (String name : list) {
            bw.write(name);
            bw.newLine();
        }

        bw.flush();
    }

}
