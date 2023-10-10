import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int[] subArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subArray);
            answer.add(subArray[command[2] - 1]);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}