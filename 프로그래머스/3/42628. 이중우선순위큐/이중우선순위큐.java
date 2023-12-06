import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for (String opertation : operations) {
            if (opertation.startsWith("I")) {
                String[] command = opertation.split(" ");
                queue.add(Integer.parseInt(command[1]));
            }

            if (opertation.equals("D -1") && !queue.isEmpty()) {
                minQueue.addAll(queue);
                queue.clear();
                minQueue.poll();
                queue.addAll(minQueue);
            }

            if (opertation.equals("D 1") && !queue.isEmpty()) {
                maxQueue.addAll(queue);
                queue.clear();
                maxQueue.poll();
                queue.addAll(maxQueue);
            }

            minQueue.clear();
            maxQueue.clear();
        }

        if (queue.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            maxQueue.addAll(queue);
            answer[0] = maxQueue.poll();

            minQueue.addAll(maxQueue);
            answer[1] = minQueue.poll();
        }

        return answer;
    }
}