import java.util.HashMap;
import java.util.Objects;
import java.util.Map.Entry;

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
                if (hm.containsValue(t.substring(i)) && !getKeyFromValue(hm, t.substring(i)).equals(s.substring(i))) {
                    return false;
                }
                break;
            }
            if (hm.get(s.substring(i, i + 1)) != null) {
                if (!hm.get(s.substring(i, i + 1)).equals(t.substring(i, i + 1))) {
                    return false;
                }
            } else if (hm.containsValue(t.substring(i, i + 1))
                    && !getKeyFromValue(hm, t.substring(i, i + 1)).equals(s.substring(i, i + 1))) {
                return false;
            } else {
                hm.put(s.substring(i, i + 1), t.substring(i, i + 1));
            }
        }

        return true;

    }

    private String getKeyFromValue(HashMap<String, String> hm, String substring) {
        for (Entry<String, String> h : hm.entrySet()) {
            if (Objects.equals(h.getValue(), substring)) {
                return h.getKey();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out
                .println(s.isIsomorphic("qwertyuiop[]asdfghjkl;'\\zxcvbnm,./", "',.pyfgcrl/=aoeuidhtns-\\;qjkxbmwvz"));
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
}