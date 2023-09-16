class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            
            int result = arr1[i] | arr2[i];
            String temp = Integer.toBinaryString(result);
            if(temp.length() < n) {
                String zeros = "0".repeat(n - temp.length());
                temp = zeros + temp;
            }
            temp = temp.replace("1", "#");
            temp = temp.replace("0", " ");
            
            answer[i] = temp;
        }
        
        return answer;
    }
}