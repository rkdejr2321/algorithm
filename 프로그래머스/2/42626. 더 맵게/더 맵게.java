import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int sco : scoville) {
            queue.add(sco);
        }
        
        if(checkScoville(queue, K)) {
            return 0;
        }
        
        while(queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            
            int mix = first + second * 2;
            answer++;
            
            queue.add(mix);
            
            if (checkScoville(queue, K)) {
                break;
            }
        }
        
        if (queue.size() == 1 && queue.peek() < K) {
            return -1;
        }
        
        return answer;
    }
    
    public boolean checkScoville(PriorityQueue<Integer> queue, int K) {
        for (Integer sco : queue) {
            if (sco < K) {
                return false;
            }
        }
        
        return true;
    }
}