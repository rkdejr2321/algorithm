import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int distance = 0;
    static List<List<Integer>> list = new ArrayList<>();
    static Queue<int[]> queue = new LinkedList<>();
    static List<int[]> nodes = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        visited = new boolean[n+1];
        
        for (int[] node : edge) {
            int u = node[0];
            int v = node[1];
            
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        visited[1] = true;
        queue.add(new int[] {1, 0});
        bfs();
        
        Collections.sort(nodes, (o1, o2) -> {
           return o2[1] - o1[1]; 
        });
        
        int max = nodes.get(0)[1];
        
        for (int[] temp : nodes) {
            if (temp[1] != max) {
                break;
            }
            
            answer++;
        }
        return answer;
    }
    
    public static void bfs() {
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            nodes.add(now);
            
            List<Integer> edge = list.get(now[0]);
            
            for (int e : edge) {
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(new int[] {e, now[1] + 1});
                }
            }
        }
    }
}