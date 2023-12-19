import java.util.*;

class Solution {
    public String solution(String s) {
        List<Integer> list = new ArrayList<>();
        
        String answer = "";
        
        String[] arr = s.split(" ");
        
        for (String num : arr) {
            list.add(Integer.parseInt(num));
        }
        
        answer += Collections.min(list);
        answer += " ";
        answer += Collections.max(list);
        
        return answer;
    }
}