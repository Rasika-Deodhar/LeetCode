import java.util.Arrays;

class Solution {
    public static int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length == 0) {
            return new int[] { 0, 0 };
        }

        int indices[] = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (target - numbers[i] > numbers[numbers.length - 1]) {
                continue;
            } else if (target - numbers[i] == numbers[numbers.length - 1]) {
                indices[0] = i + 1;
                indices[1] = numbers.length;
                return indices;
            } else {
                indices[1] = Arrays.binarySearch(Arrays.copyOfRange(numbers, i + 1, numbers.length),
                        target - numbers[i]);
                if (indices[1] >= 0) {
                    indices[0] = i + 1;
                    indices[1] += i + 2;
                    return indices;
                }
            }
        }

        return indices;
    }

    public static void main(String args[]) {
        int[] result = Solution.twoSum(new int[] { 1, 2, 3, 4, 4, 9, 56, 90 }, 8);

        for (int i : result) {
            System.out.println(i);
        }

    }

    // Time Complexity -
    // Best case -> Indices are of 1st and Last numbers
    // Avg Case -> Index 0 is first number and 2nd is somewhere between
    // Worst Case -> Index is 2nd last and last number
}