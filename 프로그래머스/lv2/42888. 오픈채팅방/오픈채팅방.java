import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for(String text : record) {
            String[] word = text.split(" ");
            if(word[0].equals("Leave")) {
                continue;
            } else{
                map.put(word[1], word[2]);
            }
        }
        
        for(String text : record) {
            String[] word = text.split(" ");
            if (word[0].equals("Enter")) {
                answer.add(map.get(word[1]) + "님이 들어왔습니다.");
            } else if(word[0].equals("Leave")) {
                answer.add(map.get(word[1]) + "님이 나갔습니다.");
            }
        }
        
        
        return answer.toArray(new String[answer.size()]);
    }
}