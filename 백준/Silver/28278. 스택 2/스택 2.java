import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            command(input);
        }

        bw.flush(); // Flush outside the loop
    }

    public static void command(String input) throws IOException {
        if (input.startsWith("1")) {
            String[] s = input.split(" ");
            stack.add(Integer.parseInt(s[1]));
        } else {
            if (input.equals("2")) {
                bw.write(stack.isEmpty() ? String.valueOf(-1) : String.valueOf(stack.pop()));
                bw.newLine();
            }

            if (input.equals("3")) {
               bw.write(String.valueOf(stack.size()));
                bw.newLine();
            }

            if (input.equals("4")) {
                bw.write(stack.isEmpty() ? String.valueOf(1) : String.valueOf(0));
                bw.newLine();
            }

            if (input.equals("5")) {
                bw.write(stack.isEmpty() ? String.valueOf(-1) : String.valueOf(stack.peek()));
                bw.newLine();
            }
        }
    }
}
