import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<String> stack = new Stack<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            boolean answer = solution(str);

            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    static boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);

            if (bracket == '(') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
