import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<String, Integer> map;

    public Solution() {
        map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        map.put("G", 7);
        map.put("H", 8);
        map.put("I", 9);
        map.put("J", 10);
        map.put("K", 11);
        map.put("L", 12);
        map.put("M", 13);
        map.put("N", 14);
        map.put("O", 15);
        map.put("P", 16);
        map.put("Q", 17);
        map.put("R", 18);
        map.put("S", 19);
        map.put("T", 20);
        map.put("U", 21);
        map.put("V", 22);
        map.put("W", 23);
        map.put("X", 24);
        map.put("Y", 25);
        map.put("Z", 26);
    }

    public int titleToNumber(String s) {

        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return map.get(s);

        int length_count = 0;

        // for (int i = 1; i <= s.length() - 1; i++) {
        // length_count += (int) Math.pow(26, i);
        // }

        int power = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            length_count += (map.get(s.substring(i, i + 1))) * (int) Math.pow(26, power);
            power++;
        }

        // length_count += map.get(s.substring(s.length() - 1, s.length()));

        return length_count;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.titleToNumber("AJHX"));
    }
}