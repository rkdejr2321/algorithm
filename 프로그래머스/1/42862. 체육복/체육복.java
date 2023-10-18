import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = 0;
        
        answer = n - lost.length;
        
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(reserve[j] + 1 == lost[i] || reserve[j] - 1 == lost[i]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}