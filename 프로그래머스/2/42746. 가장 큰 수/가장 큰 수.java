import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        
        for (int num : numbers) {
            list.add(String.valueOf(num));
        }
        
        Collections.sort(list, (o1, o2) -> {
            int temp1 = Integer.parseInt(o1+o2);
            int temp2 = Integer.parseInt(o2+o1);
            
            return temp2 - temp1;
        });
        
        for (String num : list) {
            answer += num;
        }
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}