import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int maxPriorities = priorities[0];
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
            queue.add(i);
            
            if (priorities[i] >= maxPriorities) {
                maxPriorities = priorities[i];
            }
        }
        
        while(!queue.isEmpty()) {
            if (queue.peek() == location && map.get(location) >= maxPriorities) {
                answer++;
                break;
            }
            
            if (map.get(queue.peek()) >= maxPriorities) {
                map.remove(queue.peek());
                maxPriorities = Collections.max(map.values());
                queue.remove();
                answer++;
                
            } else {
                int peek = queue.peek();
                queue.remove();
                queue.add(peek);
                
            }
        }
        
        return answer;
    }
}