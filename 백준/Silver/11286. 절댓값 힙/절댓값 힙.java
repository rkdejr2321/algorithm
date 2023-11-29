import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public
    static void main(String[] args) throws Exception {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA == absB){
                return Integer.compare(a, b);
            }

            return Integer.compare(absA, absB);
        });

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num  = sc.nextInt();

            if (num == 0 && !queue.isEmpty()) {
                System.out.println(queue.poll());
            } else if (num == 0) {
                System.out.println(0);
            } else {
                queue.add(num);
            }

        }
    }
}
