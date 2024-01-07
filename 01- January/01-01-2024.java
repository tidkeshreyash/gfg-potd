class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        if (nums.length % 2 != 0) {
            return false; // If the array length is odd, it's impossible to form pairs
        }

        HashMap<Integer, Integer> remainderCount = new HashMap<>();

        for (int num : nums) {
            int remainder = (num % k + k) % k; // Handle negative numbers
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        for (int num : nums) {
            int remainder = (num % k + k) % k; // Handle negative numbers
            int complement = (k - remainder) % k;

            if (remainder == 0) {
                // If the remainder is 0, the number must be paired with another number with remainder 0
                if (remainderCount.getOrDefault(complement, 0) % 2 != 0) {
                    return false;
                }
            } else if (remainderCount.getOrDefault(remainder, 0) != remainderCount.getOrDefault(complement, 0)) {
                // If the remainder is not 0, the count of remainders must match for pairing
                return false;
            }
        }

        return true;
    }
}