import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> route;
    
    public void dfs(String arrive, String depart, String[][] tickets, int depth) {
        if(depth == tickets.length) {
            route.add(depart);
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            if(arrive.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], depart + " " + tickets[i][1], tickets, depth+1);
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length + 1];
        route = new ArrayList<>();
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(route);
        
        return route.get(0).split(" ");
        
    }
}