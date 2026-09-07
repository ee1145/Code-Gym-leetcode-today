class Twitter {
    private int timestamp = 0;
    private Map<Integer, List<int[]>> tweets = new HashMap<>();
    private Map<Integer, Set<Integer>> follows = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
              .add(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = 
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // 把自己的推文加入堆
        if (tweets.containsKey(userId)) {
            for (int[] t : tweets.get(userId)) maxHeap.offer(t);
        }

        // 把关注者的推文加入堆
        if (follows.containsKey(userId)) {
            for (int followee : follows.get(userId)) {
                if (tweets.containsKey(followee)) {
                    for (int[] t : tweets.get(followee)) maxHeap.offer(t);
                }
            }
        }

        // 最多取10条
        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            result.add(maxHeap.poll()[1]);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>())
               .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}