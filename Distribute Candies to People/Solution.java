class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] finalArray = new int[num_people];
        int remaining_candies = candies, assign_count = 0, i = 0;

        while (remaining_candies <= candies) {
            // check if array has ended -> num_people has ended
            assign_count += 1;
            // if candies are exhausting, assign and return
            while (remaining_candies >= assign_count) {
                i = 0;
                // assign candies to a person
                while (i < num_people && remaining_candies >= assign_count) {
                    finalArray[i++] += assign_count;
                    remaining_candies -= (assign_count++);
                }
            }
            // if all exhausted -> return array
            if (remaining_candies == 0) {
                return finalArray;
            }
            // otherwise, assign all remaining, break and return

            // i's value exceeding means new round is started
            if (i == num_people) {
                finalArray[0] += remaining_candies;
                break;
            }
            // assign to the current index
            finalArray[i] += remaining_candies;
            break;
        }

        return finalArray;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.distributeCandies(7, 2);
        for (int i : result) {
            System.out.println(i);
        }
    }
}