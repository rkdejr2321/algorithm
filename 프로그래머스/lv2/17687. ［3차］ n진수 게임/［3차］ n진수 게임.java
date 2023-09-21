import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String result = "";
        int start = 0;
        
        while(result.length() < t * m) {
            result += Integer.toString(start, n);
            start++;
        }
        
        System.out.println(result);
    
        for (int i = p-1; i < t * m; i += m) {
            answer += result.charAt(i);
        }
        
        
        
        return answer.toUpperCase();
    }
}