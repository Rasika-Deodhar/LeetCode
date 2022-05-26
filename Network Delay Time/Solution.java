import java.util.HashSet;

class Solution {

    // Not running for all test cases - 
    // public int networkDelayTime(int[][] times, int n, int k) {
        
    //     int dist = -1;
    //     HashSet<Integer> received = new HashSet<>();

    //     for (int i = 0; i < times.length; i++) {
    //         if(times[i][0]==k){
    //             dist = Integer.max(dist, times[i][2]);
    //             if(!received.contains(times[i][0])){received.add(times[i][0]);}
    //             received.add(times[i][1]);
    //         }
    //     }

    //     for (int i = 0; i < times.length; i++) {
    //         if(times[i][0]!=k && received.contains(times[i][0]) && !received.contains(times[i][1])) {
    //             dist += times[i][2];
    //             received.add(times[i][1]);
    //         }
    //     }

    //     return received.size() == n ? dist : -1;
    // }

    // Dijkstra's Algorithm: https://www.youtube.com/watch?v=pVfj6mxhdMw
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int dist = 0;
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> unVisited = new HashSet<>();
        int[][] allDistances = new int[n][3];
        int smallestDistance = Integer.MAX_VALUE;
        int smallestDistanceNode = 0;

        for (int i = 0; i < n; i++) {
            if(i+1 == k) {
                allDistances[i][0] = k;
                allDistances[i][1] = 0;
            } else{
                allDistances[i][0] = i+1;
                allDistances[i][1] = Integer.MAX_VALUE;
            }
            unVisited.add(i+1);
        }

        while(!unVisited.isEmpty()){
            smallestDistance = Integer.MAX_VALUE;
            for (int[] is : allDistances) {
                if(is[1] < smallestDistance && unVisited.contains(is[0])) {
                    smallestDistance = is[1];
                    smallestDistanceNode = is[0];
                }
            }

            dist = smallestDistance;

            for (int i = 0; i < n; i++) {
                if(times[i][0] == smallestDistanceNode && unVisited.contains(times[i][1])){
                    if(allDistances[times[i][1]-1][1] > (dist + times[i][2])){
                        allDistances[times[i][1]-1][1] = dist + times[i][2];
                        allDistances[times[i][1]-1][2] = smallestDistanceNode;
                        smallestDistance = dist + times[i][2];
                    }
                }
            }

            unVisited.remove(smallestDistanceNode);
            visited.add(smallestDistanceNode);
        }

        dist=0;
        for (int is[] : allDistances) {
            dist = is[1] > dist ? is[1] : dist; 
        }

        return visited.size()==n ? dist : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().networkDelayTime(new int [][] {{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
        System.out.println(new Solution().networkDelayTime(new int [][] {{1,2,1}}, 2, 1));
        System.out.println(new Solution().networkDelayTime(new int [][] {{1,2,1}}, 2, 2));
        System.out.println(new Solution().networkDelayTime(new int [][] {{1,2,1},{2,3,2},{1,3,2}}, 3, 1));
    }
}