import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count++);
        }
        
        if (map.size() > nums.length / 2) {
            answer = nums.length / 2;
        } else {
            answer = map.size();
        }
        return answer;
    }
}