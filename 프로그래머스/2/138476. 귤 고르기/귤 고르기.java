import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (int tang : tangerine) {
            int count = map.getOrDefault(tang, 0);
            count++;
            map.put(tang, count);
        }
        
        for (int key : map.keySet()) {
            list.add(map.get(key));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for (int count : list) {
            if ( k == 0) {
                break;
            }
            
            k -= count;
            
            if (k < 0) {
                answer++;
                break;
            }
            
            answer++;
        }
        
        
        return answer;
    }
}