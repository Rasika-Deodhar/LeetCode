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
            for (List<Character> list2 : subList) {
                hashSet.clear();
                if (list2.get(0) != '.' && !hashSet.add(list2.get(0))
                        || list2.get(1) != '.' && !hashSet.add(list2.get(1))
                        || list2.get(2) != '.' && !hashSet.add(list2.get(2))) {
                    return false;
                }
                subHashSets.add(0, hashSet);
                hashSet.clear();
                if (list2.get(3) != '.' && !hashSet.add(list2.get(3))
                        || list2.get(4) != '.' && !hashSet.add(list2.get(4))
                        || list2.get(5) != '.' && !hashSet.add(list2.get(5))) {
                    return false;
                }
                subHashSets.add(1, hashSet);
                hashSet.clear();
                if (list2.get(6) != '.' && !hashSet.add(list2.get(6))
                        || list2.get(7) != '.' && !hashSet.add(list2.get(7))
                        || list2.get(8) != '.' && !hashSet.add(list2.get(8))) {
                    return false;
                }
                subHashSets.add(2, hashSet);
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
        System.out.println(s.isValidSudoku(new char[][] { { '7', '.', '.', '.', '4', '.', '.', '.', '.' },
                { '.', '.', '.', '8', '6', '5', '.', '.', '.' }, { '.', '1', '.', '2', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '9', '.', '.', '.' }, { '.', '.', '.', '.', '5', '.', '5', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' } }));
    }
}