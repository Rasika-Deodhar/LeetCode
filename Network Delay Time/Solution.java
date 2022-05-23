import java.util.HashSet;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int dist = -1;
        HashSet<Integer> received = new HashSet<>();

        for (int i = 0; i < times.length; i++) {
            if(times[i][0]==k){
                dist = Integer.max(dist, times[i][2]);
                if(!received.contains(times[i][0])){received.add(times[i][0]);}
                received.add(times[i][1]);
            }
        }

        for (int i = 0; i < times.length; i++) {
            if(times[i][0]!=k && received.contains(times[i][0]) && !received.contains(times[i][1])) {
                dist += times[i][2];
                received.add(times[i][1]);
            }
        }

        return received.size() == n ? dist : -1;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().networkDelayTime(new int [][] {{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
        // System.out.println(new Solution().networkDelayTime(new int [][] {{1,2,1}}, 2, 1));
        // System.out.println(new Solution().networkDelayTime(new int [][] {{1,2,1}}, 2, 2));
        System.out.println(new Solution().networkDelayTime(new int [][] {{1,2,1},{2,3,2},{1,3,2}}, 3, 1));
    }
}