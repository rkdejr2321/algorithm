import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> list = new LinkedList<>();
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String city : cities) {
            String lowerCity = city.toLowerCase();
            
            if (list.size() < cacheSize) {
               if(list.contains(lowerCity)) {
                   list.remove(lowerCity);
                   list.add(lowerCity);
                   answer += 1;
               } else {
                   list.add(lowerCity);
                   answer += 5;
               }
            } else {
                if(list.contains(lowerCity)) {
                    list.remove(lowerCity);
                    list.add(lowerCity);
                    answer += 1;
                } else {
                    list.remove(0);
                    list.add(lowerCity);
                    answer += 5;
                }
            }
            
        }
        
        
        return answer;
    }
}