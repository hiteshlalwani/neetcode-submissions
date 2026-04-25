class Twitter {

    private static final int MAX_FEED = 10;

    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap; // Stores [timestamp, tweetId]

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // 1. Min-Heap (smallest timestamp at the top)
        // This allows us to keep the "newest" ones and kick out the "oldest"
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // 2. Add User's tweets
        fillMinHeap(userId, minHeap);

        // 3. Add Followees' tweets
        if (followMap.containsKey(userId)) {
            for (int followeeId : followMap.get(userId)) {
                fillMinHeap(followeeId, minHeap);
            }
        }

        // 4. Convert Min-Heap to List and REVERSE (since we want newest first)
        List<Integer> res = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            res.addFirst(minHeap.poll()[1]); // addFirst keeps newest at the front
        }
        return res;
    }

    private void fillMinHeap(int userId, PriorityQueue<int[]> minHeap) {
        List<int[]> tweets = tweetMap.get(userId);
        if (tweets == null) return;
        
        // Only look at the person's last 10, as earlier ones can't possibly be in global top 10
        int n = tweets.size();
        for (int i = n - 1; i >= Math.max(0, n - 10); i--) {
            int[] tweet = tweets.get(i);
            
            // If heap is full, only add if this tweet is NEWER than the oldest in our heap
            if (minHeap.size() < 10) {
                minHeap.add(tweet);
            } else if (tweet[0] > minHeap.peek()[0]) {
                minHeap.poll();
                minHeap.add(tweet);
            }
        }
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            Set<Integer> followers = followMap.get(followerId);
            followers.remove(followeeId);
            if (followers.isEmpty()) followMap.remove(followerId);
        }
    }
}