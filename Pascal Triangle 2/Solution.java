import java.util.ArrayList;
import java.util.List;

class Solution {

    public static List<Integer> l;

    public Solution() {
        l = new ArrayList<Integer>();
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            l.add(1);
            return l;
        }
        if (rowIndex == 1) {
            l.add(1);
            l.add(1);
            return l;
        }

        l.add(1);
        l.add(1);

        List<Integer> list = recur_getRow(rowIndex);
        return list;
    }

    private List<Integer> recur_getRow(int rowIndex) {
        if (rowIndex >= 2) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(1);
            for (int i = 0; i < l.size() - 1; i++) {
                l1.add(l.get(i) + l.get(i + 1));
            }
            l1.add(1);
            l.clear();
            l.addAll(l1);
            recur_getRow(--rowIndex);
        }

        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getRow(2));
    }
}