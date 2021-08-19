import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> hashSet = new HashSet<>();
        List<List<Character>> list = new ArrayList<>();

        // convert to List of List
        for (char[] charac : board) {
            String s = charac.toString();
            list.add(s.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        }

        int i = 0;

        // Check Valid Row
        for (List<Character> row : list) {
            if (row.get(i).charValue() != '.' && !hashSet.add(row.get(i))) {
                return false;
            }
            i++;
        }

        i = 0;
        int j;
        // Check Valid Column
        for (i = 0, j = 0; i < list.size() && j < list.get(i).size(); i++, j++) {
            hashSet.clear();
            if (!hashSet.add(list.get(i).get(j))) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValidSudoku(new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
    }
}