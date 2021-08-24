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
            String s = String.valueOf(charac);
            list.add(s.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        }

        int i = 0;

        // Check Valid Row
        for (List<Character> row : list) {
            i = 0;
            hashSet.clear();
            while (i < 9) {
                if (row.get(i).charValue() != '.' && Character.getNumericValue(row.get(i)) > 0
                        && Character.getNumericValue(row.get(i)) < 10 && !hashSet.add(row.get(i))) {
                    return false;
                }
                i++;
            }
        }

        i = 0;
        int j;
        // Check Valid Column
        for (j = 0; j < 9; j++) {
            i = 0;
            hashSet.clear();
            while (i < list.size()) {
                if (list.get(i).get(j).charValue() != '.' && Character.getNumericValue(list.get(i).get(j)) > 0
                        && Character.getNumericValue(list.get(i).get(j)) < 10 && !hashSet.add(list.get(i).get(j))) {
                    return false;
                }
                i++;
            }
        }

        // Check 3 X 3 sub-boxes
        i = 3;
        j = 0;
        do {
            List<List<Character>> subList = list.subList(j, i);
            List<HashSet<Character>> subHashSets = new ArrayList<>();
            subHashSets.add(new HashSet<>());
            subHashSets.add(new HashSet<>());
            subHashSets.add(new HashSet<>());
            for (List<Character> row : subList) {
                if (row.get(0) != '.' && !subHashSets.get(0).add(row.get(0))
                        || row.get(1) != '.' && !subHashSets.get(0).add(row.get(1))
                        || row.get(2) != '.' && !subHashSets.get(0).add(row.get(2))) {
                    return false;
                }
                if (row.get(3) != '.' && !subHashSets.get(1).add(row.get(3))
                        || row.get(4) != '.' && !subHashSets.get(1).add(row.get(4))
                        || row.get(5) != '.' && !subHashSets.get(1).add(row.get(5))) {
                    return false;
                }
                hashSet.clear();
                if (row.get(6) != '.' && !subHashSets.get(2).add(row.get(6))
                        || row.get(7) != '.' && !subHashSets.get(2).add(row.get(7))
                        || row.get(8) != '.' && !subHashSets.get(2).add(row.get(8))) {
                    return false;
                }
            }
            j = i;
            i += 3;
        } while (i <= 9);

        return true;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.isValidSudoku(new char[][] { { '5', '3', '.', '.', '7',
        // '.', '.', '.', '.' },
        // { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.',
        // '.', '.', '6', '.' },
        // { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.',
        // '3', '.', '.', '1' },
        // { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.',
        // '.', '2', '8', '.' },
        // { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8',
        // '.', '.', '7', '9' } }));
        // System.out.println(s.isValidSudoku(new char[][] { { '8', '3', '.', '.', '7',
        // '.', '.', '.', '.' },
        // { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.',
        // '.', '.', '6', '.' },
        // { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.',
        // '3', '.', '.', '1' },
        // { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.',
        // '.', '2', '8', '.' },
        // { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8',
        // '.', '.', '7', '9' } }));
        System.out.println(s.isValidSudoku(new char[][] { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } }));
    }

    // Time Complexity = O(N^2)
    // Space Complexity = O(N^2)
}