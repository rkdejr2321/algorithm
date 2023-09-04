class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long target = Long.parseLong(p);
        int range = t.length() - p.length();
        
        for(int i = 0; i < range + 1; i++) {
            String subStr = t.substring(i, i+p.length());
            Long value = Long.parseLong(subStr);
            
            if (target >= value) {
                answer += 1;
            }
        }
        
        return answer;
    }
}