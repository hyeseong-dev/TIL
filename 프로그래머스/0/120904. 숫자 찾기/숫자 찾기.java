class Solution {
    public int solution(int num, int k) {
        String[] numArr = String.valueOf(num).split("");

        for (int i = 0;i < numArr.length; i++) {
            if (String.valueOf(k).equals(numArr[i])) {
                return i + 1;
            }
        }

        return -1;
    }
}