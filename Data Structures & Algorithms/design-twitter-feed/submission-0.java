class Twitter {

    // time counter to keep tweets ordered
    private int time;

    // user -> list of tweets
    private Map<Integer, List<Tweet>> tweets;

    // user -> set of followees
    private Map<Integer, Set<Integer>> followMap;

    // Tweet structure
    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        time = 0;
        tweets = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> tweets.get(b[0]).get(b[1]).time -
                          tweets.get(a[0]).get(a[1]).time
        );

        // include the user himself
        Set<Integer> users = new HashSet<>();
        users.add(userId);

        if (followMap.containsKey(userId)) {
            users.addAll(followMap.get(userId));
        }

        // push latest tweet index of each user
        for (int u : users) {
            if (!tweets.containsKey(u)) continue;

            int idx = tweets.get(u).size() - 1;
            maxHeap.offer(new int[]{u, idx});
        }

        List<Integer> res = new ArrayList<>();

        while (!maxHeap.isEmpty() && res.size() < 10) {

            int[] cur = maxHeap.poll();
            int u = cur[0];
            int idx = cur[1];

            res.add(tweets.get(u).get(idx).id);

            // push next older tweet of same user
            if (idx - 1 >= 0) {
                maxHeap.offer(new int[]{u, idx - 1});
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) return;

        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!followMap.containsKey(followerId)) return;

        followMap.get(followerId).remove(followeeId);
    }
}