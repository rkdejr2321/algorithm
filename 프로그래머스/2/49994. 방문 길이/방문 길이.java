import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        Map<String, Integer> visited = new HashMap<>();

        int answer = 0;

        int[] now = new int[] {0, 0};
        String[] commands = dirs.split("");

        for (String command : commands) {

            if (command.equals("U")) {
                int[] move = new int[2];
                move[0] = now[0];
                move[1] = now[1] + 1;

                if (move[0] > 5 || move[0] < -5 || move[1] > 5 || move[1] < -5) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                String pass1 = sb.append(now[0]).append(now[1]).append(move[0]).append(move[1]).toString();

                sb = new StringBuilder();
                String pass2 = sb.append(move[0]).append(move[1]).append(now[0]).append(now[1]).toString();

                if (!visited.containsKey(pass1) && !visited.containsKey(pass2)) {
                    visited.put(pass1, 1);
                    visited.put(pass2, 1);
                    answer++;
                }

                now = move;
            }

            if (command.equals("D")) {
                int[] move = new int[2];
                move[0] = now[0];
                move[1] = now[1] - 1;
                if (move[0] > 5 || move[0] < -5 || move[1] > 5 || move[1] < -5) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                String pass1 = sb.append(now[0]).append(now[1]).append(move[0]).append(move[1]).toString();

                sb = new StringBuilder();
                String pass2 = sb.append(move[0]).append(move[1]).append(now[0]).append(now[1]).toString();

                if (!visited.containsKey(pass1) && !visited.containsKey(pass2)) {
                    visited.put(pass1, 1);
                    visited.put(pass2, 1);
                    answer++;
                }
                now = move;
            }

            if (command.equals("R")) {
                int[] move = new int[2];
                move[0] = now[0] + 1;
                move[1] = now[1];
                if (move[0] > 5 || move[0] < -5 || move[1] > 5 || move[1] < -5) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                String pass1 = sb.append(now[0]).append(now[1]).append(move[0]).append(move[1]).toString();

                sb = new StringBuilder();
                String pass2 = sb.append(move[0]).append(move[1]).append(now[0]).append(now[1]).toString();

                if (!visited.containsKey(pass1) && !visited.containsKey(pass2)) {
                    visited.put(pass1, 1);
                    visited.put(pass2, 1);
                    answer++;
                }
                now = move;
            }

            if (command.equals("L")) {
                int[] move = new int[2];
                move[0] = now[0] - 1;
                move[1] = now[1];
                if (move[0] > 5 || move[0] < -5 || move[1] > 5 || move[1] < -5) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                String pass1 = sb.append(now[0]).append(now[1]).append(move[0]).append(move[1]).toString();

                sb = new StringBuilder();
                String pass2 = sb.append(move[0]).append(move[1]).append(now[0]).append(now[1]).toString();

                if (!visited.containsKey(pass1) && !visited.containsKey(pass2)) {
                    visited.put(pass1, 1);
                    visited.put(pass2, 1);
                    answer++;
                }
                now = move;
            }

        }


        return answer;
    }
}