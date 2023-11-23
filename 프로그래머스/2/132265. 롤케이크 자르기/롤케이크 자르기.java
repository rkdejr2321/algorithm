import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        
        for (int top : topping) {
            int count = map.getOrDefault(top, 0);
            count++;
            map.put(top, count);
        }
        
        for (int top : topping) {
            int get = map.get(top);
            
            set.add(top);
            
            map.put(top, get - 1);
            
            if (get == 1) {
                map.remove(top);
            }
            
            if(set.size() == map.size()) {
                answer++;
            }
        }
        
        
        
        return answer;
    
    }
    
}