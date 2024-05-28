class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        return numbers[2 * (k - 1) % numbers.length];
        
        
    }
}