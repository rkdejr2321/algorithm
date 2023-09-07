import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        
        for (String phone : phone_book) {
            for(int i = 0; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if(map.containsKey(prefix)) {
                    return false;
                }
            }
        } 
        return true;
    }
}