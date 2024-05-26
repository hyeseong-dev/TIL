class Solution {
    public int solution(int n) {
        int factorial = 1;
        int i = 1;
        while (factorial <= n) {
            i++;
            factorial *= i;
        }
        return i - 1;
    }

}