import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int hit = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        for(int lotto: lottos) {
            if(lotto != 0) {
                map.put(lotto, true);
            } else {
                zeroCount++;
            }
        }
        
        for(int num : win_nums) {
            if(map.containsKey(num)) {
                hit++;
            }
        }
        
        answer[0] = checkRank(hit + zeroCount);
        answer[1] = checkRank(hit);
        
        return answer;
    }
    
    private int checkRank(int hit) {
        int rank = 0;
        switch (hit) {
            case 6:
                rank = 1;
                break;
            case 5:
                rank = 2;
                break;
            case 4:
                rank = 3;
                break;
            case 3:
                rank = 4;
                break;
            case 2:
                rank = 5;
                break;
            default:
                rank = 6;
                break;
        }
        return rank;
    }
}