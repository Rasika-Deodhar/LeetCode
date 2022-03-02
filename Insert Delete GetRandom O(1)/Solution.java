import java.util.HashSet;
import java.util.Random;

class RandomizedSet {

    HashSet<Integer> randomSet;

    public RandomizedSet() {
        randomSet = new HashSet<>();
    }

    public boolean insert(int val) {
        return randomSet.add(val);
    }

    public boolean remove(int val) {
        return randomSet.remove(val);
    }

    public int getRandom() {
        Integer[] randomArray = randomSet.toArray(new Integer[randomSet.size()]);
        return randomArray[new Random().nextInt(randomArray.length)].intValue();
    }

    public static void main(String[] args) {
        String[] input1 = new String[] { "RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert",
                "getRandom" };
        int[] input2 = new int[] { 1, 2, 2, 1, 2 };
        RandomizedSet rs = new RandomizedSet();
        int j = 0;

        for (String i : input1) {
            switch (i) {
                case "RandomizedSet":
                    rs = new RandomizedSet();
                    break;
                case "insert":
                    if (j < input2.length) {
                        System.out.println(rs.insert(input2[j++]));
                    }
                    break;
                case "remove":
                    if (j < input2.length) {
                        System.out.println(rs.remove(input2[j++]));
                    }
                    break;
                case "getRandom":
                    System.out.println(rs.getRandom());
                    break;
            }
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */