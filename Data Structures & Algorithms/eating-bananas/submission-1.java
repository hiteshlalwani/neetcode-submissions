class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) return 0;
        long low = 1;
        long high = 0;
        for (int pile : piles) {
            high += pile;
        }
        while (low < high) {
            long mid = (low + (high - low)/2);
            if (canEatAll(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int)low;
    }

    private boolean canEatAll(int[] piles, long speed, int k) {
        int count = 0;
        for (int pile : piles) {
            count += ((pile + speed-1)/speed);
            if (count > k) return false;
        }
        return true;
    }
}
