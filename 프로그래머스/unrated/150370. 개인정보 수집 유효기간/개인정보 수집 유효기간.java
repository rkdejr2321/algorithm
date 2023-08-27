import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        int todayYear = Integer.parseInt(today.split("\\.")[0]);
        int todayMonth = Integer.parseInt(today.split("\\.")[1]);
        int todayDay = Integer.parseInt(today.split("\\.")[2]);
            
        int todayDate = Integer.parseInt(String.format("%04d%02d%02d", todayYear, todayMonth, todayDay));
        
        HashMap<String, Integer> termMap = new HashMap<>();
        
        for (int i = 0; i < terms.length; i++) {
            String type = terms[i].split(" ")[0];
            Integer value = Integer.parseInt(terms[i].split(" ")[1]);
            
            termMap.put(type, value);
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String date = privacies[i].split(" ")[0];
            String type = privacies[i].split(" ")[1];
            
            int year = Integer.parseInt(date.split("\\.")[0]);
            int month = Integer.parseInt(date.split("\\.")[1]);
            int day = Integer.parseInt(date.split("\\.")[2]);
            
            int expireTerm = termMap.get(type);
            
            // 월과 년도 계산 처리
            year += (month + expireTerm - 1) / 12;
            month = (month + expireTerm - 1) % 12 + 1;
            
            int expireResult = Integer.parseInt(String.format("%04d%02d%02d", year, month, day));
           
            if (todayDate >= expireResult) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}
