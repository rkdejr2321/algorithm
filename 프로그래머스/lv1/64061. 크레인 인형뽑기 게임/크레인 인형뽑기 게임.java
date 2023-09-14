import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int move: moves) {
            int now = 0;
            for(int i = 0; i < board.length; i++) {
                if(board[i][move - 1] != 0) {
                    now = board[i][move - 1];
                    board[i][move - 1] = 0;
                    break;
                }
            }

            if (now != 0) {
                if (stack.size() == 0) {
                    stack.push(now);
                } else if (now == stack.peek()) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(now);
                }
            }
        }

        return answer;
    }
}