import java.util.*;

class Solution {
    
    
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    public static int bfs(int x, int y, int n) {
        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
  
        int[] start = new int[] {x, 0};
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            if (now[0] == y) {
                return now[1];
            }
            
            if (now[0] + n <= y && !set.contains(now[0] + n)) {
                set.add(now[0] + n);
                queue.add(new int[] {now[0] + n, now[1] + 1});
            }
            
            if (now[0] * 2 <= y && !set.contains(now[0] * 2)) {
                set.add(now[0] * 2);
                queue.add(new int[] {now[0] * 2, now[1] + 1});
            }
            
            if (now[0] * 3 <= y && !set.contains(now[0] * 3)) {
                set.add(now[0] * 3);
                queue.add(new int[] {now[0] * 3, now[1] + 1});
            }
        }
        
        return -1;
    }
}