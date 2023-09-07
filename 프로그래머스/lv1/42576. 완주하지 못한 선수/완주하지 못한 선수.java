import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++) {
            int called = map.getOrDefault(participant[i], 0);
            map.put(participant[i], called + 1);
        }
        
        for(String name: completion) {
            int called = map.get(name);
            map.put(name, called - 1);
        }
        
        for(String name: participant) {
            if(map.get(name) == 1) {
                answer = name;
            }
        }
        
        
        return answer;
    }
}