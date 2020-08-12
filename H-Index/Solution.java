import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {

        if (citations.length == 0)
            return 0;
        if (citations.length == 1 && citations[0] == 0)
            return 0;
        if (citations.length == 1 && citations[0] != 0)
            return 1;

        // HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer,
        // HashMap<Integer, Integer>>();
        Arrays.sort(citations);
        int k = citations.length - 1;
        for (int i = 0; i < k; i++) {
            int temp = citations[i];
            citations[i] = citations[k];
            citations[k] = temp;
        }

        // for (int i = 0; i < citations.length; i++) {
        // HashMap<Integer, Integer> map1 = new HashMap<>();
        // int atLeast = 0;
        // int noMoreThan = 0;
        // if (citations[i] == 0) {
        // continue;
        // }
        // atLeast = citations.length - i;
        // if (i == 0) {
        // noMoreThan = 0;
        // } else {
        // Set<Integer> set = new HashSet<Integer>();
        // for (int j = 0; j < i; j++) {
        // set.add(citations[j]);
        // }
        // noMoreThan = set.size();
        // }
        // map1.put(Integer.valueOf(atLeast), Integer.valueOf(noMoreThan));
        // map.put(citations[i], map1);
        // }

        // int value = 0;

        // for (Integer i : map.keySet()) {
        // for (int j : map.get(i).keySet()) {
        // if (i == j) {
        // value = Integer.valueOf(i);
        // }
        // }
        // }

        int value = 0;
        int i, j;
        for (i = 0; i < citations.length; i++) {
            if (i >= citations[i]) {
                value = citations[i];
            }
        }
        if (value == 0)
            value = citations[citations.length - 1];

        return value;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.hIndex(new int[] { 0,0,1 }));
    }
}