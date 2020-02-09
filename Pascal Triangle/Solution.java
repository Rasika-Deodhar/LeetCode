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
            List<Integer> b = new ArrayList<>();
            a.add(1);
            l.add(a);
            b.add(1); b.add(1);
            l.add(b);
            return l;
        }

        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a1.add(1);
        l.add(a1);
        a2.add(1); a2.add(1);
        l.add(a2);

        b.addAll(a2);

        for (int i = 2; i < numRows; i++) {
            List<Integer> c = new ArrayList<>();
            c.add(0,1);
            for(int j=0; j<b.size()-1; j++){
                c.add(b.get(j)+b.get(j+1));
            }
            c.add(1);
            b.clear();
            b.addAll(c);
            l.add(c);
        }

        return l;
        
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int numRows = 5;
        List<List<Integer>> l = new ArrayList<>();
        l = s.generate(numRows);

        for (int i = 0; i < l.size(); i++) {
            for (Integer j : l.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}