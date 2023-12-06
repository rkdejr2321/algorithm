class Solution {
    static boolean visited[];
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public void dfs(String now, String target, String[] words, int count) {
        if (target.equals(now)) {
            answer = count;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            int k = 0;
            for (int j = 0; j < now.length(); j++) {
                if (words[i].charAt(j) != now.charAt(j)) {
                    k++;
                }
            }
            
            if (k == 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }
}