import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int R;
    static int C;
    static int answer = 1;
    static int max = 0;
    static String map[][];
    static Map<String, Integer> alphabet = new HashMap<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new String[R][C];

        for (int i = 0; i < R; i++) {
            String[] alphabet = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = alphabet[j];
            }
        }
        alphabet.put(map[0][0], 1);

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((nx >= 0 && ny >= 0 && nx < R && ny < C) && alphabet.getOrDefault(map[nx][ny], 0) == 0) {
                alphabet.put(map[nx][ny], 1);
                answer++;
                dfs(nx, ny);
                answer--;
                //방문 취소
                alphabet.remove(map[nx][ny]);
            }

            max = Math.max(max, answer);
        }
    }
}
