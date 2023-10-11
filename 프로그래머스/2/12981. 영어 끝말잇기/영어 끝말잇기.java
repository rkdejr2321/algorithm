import java.util.*; 

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Boolean> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>(Arrays.asList(words));
        
        int round = 1;
        int turn = 2;
        String before = queue.poll();
        map.put(before, true);
        
        while(!queue.isEmpty()) {
            if(turn > n) {
                turn = 1;
                round++;
                continue;
            }
            
            String now = queue.poll();
            
            char beforeLastChar = before.charAt(before.length() -1);
            char nowFirstChar = now.charAt(0);
            if(beforeLastChar != nowFirstChar || map.containsKey(now)) {
                answer[0] = turn;
                answer[1] = round;
                break;
            } else {
                map.put(now, true);
                before = now;
                turn++;
            }
        }
    

        return answer;
    }
}