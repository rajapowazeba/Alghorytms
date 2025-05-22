class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;

        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);
            int temp = max | (1 << i);
            Set<Integer> prefixes = new HashSet<>();

            for (int num : nums) {
                prefixes.add(num & mask);
            }

            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ temp)) {
                    max = temp;
                    break;
                }
            }
        }

        return max;
    }
}
