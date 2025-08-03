package leetcode;

import java.util.*;

public class DesignTwitter {

    public static int time = 0;
    static class Tweet {
        int tweetId;
        int timeStamp;
        Tweet tweet;
        public Tweet(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }

    Map<Integer, Tweet> tweets;
    Map<Integer, Set<Integer>> following;

    public DesignTwitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time++);
        tweet.tweet = tweets.get(userId);
        tweets.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> b.timeStamp - a.timeStamp);

        Set<Integer> followingSet = following.getOrDefault(userId, new HashSet<>());
        followingSet.add(userId);

        for (int user : followingSet) {
            if (tweets.containsKey(user)) {
                pq.add(tweets.get(user));
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {
            Tweet tweet = pq.poll();
            result.add(tweet.tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        following.computeIfAbsent(followerId, _ -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
    public static void main(String[] args) {
        DesignTwitter designTwitter = new DesignTwitter();
        designTwitter.postTweet(1, 5);
        System.out.println(designTwitter.getNewsFeed(1));
        designTwitter.follow(1,2);
        designTwitter.postTweet(2, 6);
        System.out.println(designTwitter.following.get(1));
        designTwitter.unfollow(1,2);

        System.out.println(designTwitter.getNewsFeed(1));
    }
}
