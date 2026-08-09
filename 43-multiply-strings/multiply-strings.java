class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';

                int product = n1 * n2;
                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = product + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int digit : result) {
            if (sb.length() == 0 && digit == 0) {
                continue;
            }
            sb.append(digit);
        }

        return sb.toString();
    }
}