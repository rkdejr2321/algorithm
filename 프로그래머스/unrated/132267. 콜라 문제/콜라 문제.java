class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
            int cokeQuantity = 0;
            cokeQuantity = (n / a) * b; // 병 교체
            answer += cokeQuantity;
            n = cokeQuantity + (n % a);
        }
        return answer;
    }
}