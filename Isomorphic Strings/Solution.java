import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<String, String> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                if (hm.get(s.substring(i)) != null) {
                    if (!hm.get(s.substring(i)).equals(t.substring(i))) {
                        return false;
                    }
                }
                break;
            }
            if (hm.get(s.substring(i, i + 1)) != null) {
                if (!hm.get(s.substring(i, i + 1)).equals(t.substring(i, i + 1))) {
                    return false;
                }
            } else {
                hm.put(s.substring(i, i + 1), t.substring(i, i + 1));
            }
        }

        return true;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("foo", "bar"));
    }
}