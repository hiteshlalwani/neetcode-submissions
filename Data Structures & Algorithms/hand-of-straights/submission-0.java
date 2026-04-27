class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Base case: if total cards aren't divisible by groupSize, it's impossible
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Use a TreeMap to store frequencies and keep keys sorted
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        while (!countMap.isEmpty()) {
            // Always start with the smallest available card
            int first = countMap.firstKey();
            
            for (int i = 0; i < groupSize; i++) {
                int currentCard = first + i;
                
                // If the next consecutive card is missing, we can't form the group
                if (!countMap.containsKey(currentCard)) {
                    return false;
                }
                
                // Decrement the count
                int count = countMap.get(currentCard);
                if (count == 1) {
                    countMap.remove(currentCard);
                } else {
                    countMap.put(currentCard, count - 1);
                }
            }
        }

        return true;
    }
}