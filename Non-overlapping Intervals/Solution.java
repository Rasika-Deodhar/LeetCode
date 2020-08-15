import java.util.ArrayList;
import java.util.List;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;
        if (intervals[0].length == 0 && intervals.length == 1)
            return 0;

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (intervals[i].length == 0) {
                continue;
            }
            for (int j : intervals[i]) {
                list.add(j);
            }
            lists.add(list);
        }

        if (lists.size() == 0)
            return 0;

        for (int i = 0; i < lists.size() - 1; i++) {
            int min = i;

            for (int j = i + 1; j < lists.size(); j++) {
                if (lists.get(j).get(1) < lists.get(min).get(1)) {
                    min = j;
                }
            }
            List<Integer> temp = lists.get(min);
            List<Integer> l1 = lists.get(i);
            lists.set(min, l1);
            lists.set(i, temp);
        }

        int startPoint = lists.get(0).get(0);
        int endPoint = lists.get(0).get(1);
        int flag = 0, count = 0;

        for (List<Integer> list : lists) {
            if (flag == 0) {
                flag = 1;
                continue;
            }
            if (startPoint < list.get(1) && list.get(0) < endPoint) {
                count++;
                continue;
            }
            endPoint = list.get(1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.eraseOverlapIntervals(new int[][] { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } }));
    }
}