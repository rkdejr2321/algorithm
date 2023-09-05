class Solution {
    
    public void dfs(int[][] computers, boolean[] visited, int v) {
        visited[v] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[v][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i =0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
            
        }
        return answer;
    }
}