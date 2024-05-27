class Solution {
    public static int solution(String my_string) {
        String[] strList = my_string.split(" ");

        int result = Integer.parseInt(strList[0]);

        for(int i = 1; i < strList.length; i+=2) {
            String operator = strList[i];
            int operand = Integer.parseInt(strList[i + 1]);

            switch (operator) {
                case ("+"):{
                    result += operand;
                    break;
                }
                case("-"): {
                    result -= operand;
                }
            }
        }


        return result;
    }
}
    
    
