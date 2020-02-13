class Solution {

    public String addition(String a, String b) {
        String result = "";
        char carry = '0';

        for (int i = a.length() - 1; i >= 0; i--) {
            if ((int) (char) (a.charAt(i) ^ b.charAt(i)) == 0 && carry == '0') {
                if (a.charAt(i) == '1' || b.charAt(i) == '1') {
                    carry = '1';
                }
                result += '0';
            } else if ((int) (char) (a.charAt(i) ^ b.charAt(i)) == 1 && carry == '0'
                    || (int) (char) (a.charAt(i) ^ b.charAt(i)) == 0 && carry == '1') {
                if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                    result += '1';
                    carry = '1';
                } else {
                    result += '1';
                    carry = '0';
                }
            } else if ((int) (char) (a.charAt(i) ^ b.charAt(i)) == 1 && carry == '1') {
                if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                    result += '1';
                    carry = '1';
                } else {
                    result += '0';
                    carry = '1';
                }
                // result += '0';
                // carry = '1';
            }
        }
        if (carry == '1') {
            result += '1';
        }

        result = new StringBuilder(result).reverse().toString();
        return result;
    }

    public String addBinary(String a, String b) {

        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        int length_diff = Math.abs(a.length() - b.length());

        if (a.length() > b.length()) {
            String add_on = "";
            for (int i = 0; i < length_diff; i++) {
                add_on += "0";
            }
            String new_b = add_on + b;
            return addition(a, new_b);
        } else if (a.length() < b.length()) {
            String add_on = "";
            for (int i = 0; i < length_diff; i++) {
                add_on += "0";
            }
            String new_a = add_on + a;
            return addition(new_a, b);
        }

        return addition(a, b);

    }

    public static void main(String args[]) {
        Solution s = new Solution();
        String a = "1111", b = "1111";
        System.out.println(s.addBinary(a, b));
    }
}