class Solution {
    public static int solution(String myString) {
        int sum = 0;
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < myString.length(); i++) {
            char ch = myString.charAt(i);
            if (Character.isDigit(ch)) {
                number.append(ch);
            } else {
                sum += parseIntOrZero(number.toString());
                number.setLength(0); // StringBuilder 비우기
            }
        }

        // 마지막 숫자 처리
        sum += parseIntOrZero(number.toString());

        return sum;
    }

    private static int parseIntOrZero(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}