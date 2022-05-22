import java.util.HashMap;

class Solution {

    HashMap<String, Integer> romanToInteger = new HashMap<>();
    HashMap<String, Integer> romanPriority = new HashMap<>();

    public int romanToInt(String s) {

        setHashMaps();

        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            if((i+1 != s.length()) && romanPriority.get(s.substring(i, i+1)) < romanPriority.get(s.substring(i+1, i+2))){
                num += romanToInteger.get(s.substring(i+1, i+2)) - romanToInteger.get(s.substring(i, i+1));
                i++;
            } else {
                num += romanToInteger.get(s.substring(i, i+1));
            }
        }

        return num;
        
    }

    public void setHashMaps() {
        romanToInteger.put("I", 1);
        romanToInteger.put("V", 5);
        romanToInteger.put("X", 10);
        romanToInteger.put("L", 50);
        romanToInteger.put("C", 100);
        romanToInteger.put("D", 500);
        romanToInteger.put("M", 1000);

        romanPriority.put("I", 1);
        romanPriority.put("V", 2);
        romanPriority.put("X", 3);
        romanPriority.put("L", 4);
        romanPriority.put("C", 5);
        romanPriority.put("D", 6);
        romanPriority.put("M", 7);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("LVIII"));
    }
}