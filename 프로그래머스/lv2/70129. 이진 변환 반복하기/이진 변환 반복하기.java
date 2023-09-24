class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int round = 0;
        
        while(true) {
            if(s.equals("1")) {
                break;
            }
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    zeroCount += 1;
                }
            }
            
            s = s.replaceAll("0", "");
            
            s = Integer.toBinaryString(s.length());
            
            round += 1;
        }
        answer[0] = round;
        answer[1] = zeroCount;
        return answer;
    }
}