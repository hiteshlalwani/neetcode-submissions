class Solution {
    public List<Integer> partitionLabels(String s) {
        // Step 1: Record the last occurrence index of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int size = 0;
        int end = 0;

        // Step 2: Iterate through the string to find partition boundaries
        for (int i = 0; i < s.length(); i++) {
            size++;
            // The current partition must extend to the furthest 'last index' 
            // of any character seen so far in this partition
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            // If the current index matches the furthest last index, 
            // we've found a valid partition boundary
            if (i == end) {
                result.add(size);
                size = 0; // Reset size for the next partition
            }
        }

        return result;
    }
}