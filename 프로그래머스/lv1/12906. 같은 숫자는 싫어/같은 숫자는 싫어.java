import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        
        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int lastIndex = answer.size() - 1;
            if(answer.get(lastIndex) != arr[i]) {
                answer.add(arr[i]);
            }    
        }
        
        return answer.stream().mapToInt(Integer -> Integer).toArray();
    }
}