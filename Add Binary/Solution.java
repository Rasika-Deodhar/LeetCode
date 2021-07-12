class Solution {

    public static String addition(String a, String b) {

        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return null;
        }

        Double da = 0D, db = 0D, dr = 0D;
        String res = "";

        for (int i = a.length() - 1, j = 0; i >= 0; i--, j++) {
            da += Math.pow(2, j) * Double.valueOf(a.substring(i, i + 1));
        }
        for (int i = b.length() - 1, j = 0; i >= 0; i--, j++) {
            db += Math.pow(2, j) * Double.valueOf(b.substring(i, i + 1));
        }

        dr = da + db;

        if (dr == 0) {
            return "0";
        }

        for (; dr > 0D; dr /= 2D) {
            res += String.valueOf((int) (dr % 2D));
        }

        StringBuilder final_res = new StringBuilder(res).reverse();
        String final_res1 = "";
        if (final_res.substring(0, 1).equals("0")) {
            int i = 0;
            for (i = 0; i < final_res.length() && final_res.substring(i, i + 1).equals("0"); i++) {
            }

            if (i == final_res.length()) {
                return "0";
            }
            final_res1 = final_res.substring(i).toString();
        }

        return final_res1;
    }

    public static void main(String args[]) {
        System.out.println(Solution.addition(
                "110111101100010011000101110110100000011101000101011000000000000000000000000000000000000000000000000",
                "1011"));
        System.out.println(Double.parseDouble(
                "110111101100010011000101110110100000011101000101011000000000000000000000000000000000000000000000000"));
        System.out.println(Integer.parseInt("1011", 2));
    }
}