import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < speeds.length; i++) {
            int workQuantity = 100 - progresses[i];
            
            if (workQuantity % speeds[i] != 0) {
                queue.add(workQuantity / speeds[i] + 1);
            } else {
                queue.add(workQuantity / speeds[i]);
            }
        }
        int nowDay = queue.peek();
        int count = 0;
        while(!queue.isEmpty()) {
            if(queue.peek() <= nowDay) {
                count++;
                queue.remove();
            } else {
                answer.add(count);
                nowDay = queue.peek();
                count = 0;
            }
        }
        
        answer.add(count);
        
        return answer.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
    }
}