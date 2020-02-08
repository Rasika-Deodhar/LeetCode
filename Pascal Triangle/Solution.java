import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> l = new ArrayList<>();

        if (numRows == 0) {
            return l;
        }
        if (numRows == 1) {
            List<Integer> a = new ArrayList<>();
            a.add(1);
            l.add(a);
            return l;
        }
        if (numRows == 2) {
            List<Integer> a = new ArrayList<>();
            a.add(1);
            l.add(a);
            a.clear();
            a.add(1); a.add(1);
            l.add(a);
            return l;
        }

        List<Integer> a = new ArrayList<>();
        a.add(1);
        l.add(a);
        a.clear();
        a.add(1); a.add(1);
        l.add(a);

        a.add(1,a.get(0)+a.get(1));
        l.add(a);

        return l;
        
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int numRows = 3;
        List<List<Integer>> l = new ArrayList<>();
        l = s.generate(numRows);

        for (int i = 0; i < l.size(); i++) {
            for(Integer j : l.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}