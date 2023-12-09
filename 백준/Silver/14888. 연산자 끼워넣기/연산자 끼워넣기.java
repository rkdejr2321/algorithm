import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int[] operation = new int[4];

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st1.nextToken());
        }

        dfs(nums, 1, nums[0]);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int[] nums, int depth, int num) {
        if (depth == nums.length) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;

                switch (i) {
                    case 0: dfs(nums, depth + 1, num + nums[depth]); break;
                    case 1: dfs(nums, depth + 1, num - nums[depth]); break;
                    case 2: dfs(nums, depth + 1, num * nums[depth]); break;
                    case 3: dfs(nums, depth + 1, num / nums[depth]); break;
                }
                operation[i]++;
            }
        }
    }


}
