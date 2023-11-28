import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> line = new LinkedList<>();
        Stack<Integer> wait = new Stack<>();

        for(int i = 0; i < n; i++) {
            line.offer(sc.nextInt());
        }

        int start = 1;

        while(!line.isEmpty()) {
            if(line.peek() == start) {
                line.poll();
                start++;
            }else if(!wait.isEmpty() && wait.peek() == start) {
                wait.pop();
                start++;
            }else {
                wait.push(line.poll());
            }
        }
        while(!wait.isEmpty()) {
            if(wait.peek() == start) {
                wait.pop();
                start++;
            }else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
