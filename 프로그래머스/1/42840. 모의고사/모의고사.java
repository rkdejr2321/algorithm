import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] hit = {0, 0, 0};
        
        Integer[] one = {1, 2, 3, 4, 5}; // 10개
        Integer[] two = {2, 1, 2, 3, 2, 4, 2, 5}; // 8개
        Integer[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개

        Queue<Integer> oneQueue = new LinkedList<>(Arrays.asList(one));
        Queue<Integer> twoQueue = new LinkedList<>(Arrays.asList(two));
        Queue<Integer> threeQueue = new LinkedList<>(Arrays.asList(three));
        
        for(int ans : answers) {
            if (oneQueue.peek() == ans) {
                hit[0] += 1;
            }
            if (twoQueue.peek() == ans) {
                hit[1] += 1;
            }
            if (threeQueue.peek() == ans) {
                hit[2] += 1;
            }

            //채점 후 답안을 반복
            oneQueue.add(oneQueue.poll());
            twoQueue.add(twoQueue.poll());
            threeQueue.add(threeQueue.poll());
        }
        
        int max = hit[0];
        for(int score : hit) {
            if(score >= max) {
                max = score;
            }
        }
        
        for(int i = 0; i < hit.length; i++) {
            if(hit[i] == max) {
                answer.add(i+1);
            }
        }
        
        System.out.println(Arrays.toString(hit));
        
        return answer.stream().mapToInt(Integer:: intValue).toArray();
    }
}
