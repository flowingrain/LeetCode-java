package LeetCode;

import java.util.*;

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
public class L355_DesignTwitter {
    int feedNum;
    private int order=0;
    Map<Integer,HashSet<Integer>> follows;//关注的人
    Map<Integer,LinkedList<Tweet>> tweets;//用户的推特集合
    private class Tweet{//记录推特
        Integer tweetID;
        //Long timestamp;
        Integer timestamp;
        public Tweet(int id){
            tweetID=id;
            //timestamp=System.currentTimeMillis();
            timestamp=order++;
        }

        /*
        HashSet不能添加重复的元素，当调用add（Object）方法时候，
首先会调用Object的hashCode方法判hashCode是否已经存在，如不存在则直接插入元素；
如果已存在则调用Object对象的equals方法判断是否返回true，如果为true则说明元素已经存在，如为false则插入元素。
         */
       public int hashCode() {
            return tweetID.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            Tweet tweet = (Tweet) obj;
            return tweet.tweetID.equals(this.tweetID);
        }
    }

    /** Initialize your data structure here. */
    public L355_DesignTwitter() {//不是为特定用户创建，此处不包含用户id.//提交时需要修改此处和类名
        feedNum=10;
        follows=new HashMap<Integer, HashSet<Integer>>();
        tweets=new HashMap<Integer, LinkedList<Tweet>>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId))
        {
            LinkedList<Tweet> ll=new LinkedList<Tweet>();
            tweets.put(userId,ll);
        }
        Tweet tweet=new Tweet(tweetId);
        tweets.get(userId).add(tweet);
    }

    private static class TweetComparator implements Comparator<Tweet>{
        @Override
        public int compare(Tweet o1, Tweet o2) {
            /*if (o1.timestamp.compareTo(o2.timestamp) == 0) {
                return -o1.tweetID.compareTo(o2.tweetID);
            } else {
                return o1.timestamp.compareTo(o2.timestamp);
            }*/
            return o1.timestamp.compareTo(o2.timestamp);
        }
    }
    private void sortTweet(List<Tweet> ll){
        Collections.sort(ll,new TweetComparator());
    }
    private List<Tweet> removeRepeatTweet(List<Tweet> ll){
        Set<Tweet> st=new HashSet<Tweet>(ll);
        return new LinkedList<Tweet>(st);
    }
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> ll=new LinkedList<Tweet>();
        if(tweets.containsKey(userId))
        {
            LinkedList<Tweet> temp=tweets.get(userId);
            if(temp.size()>feedNum)
                ll.addAll(temp.subList(temp.size()-feedNum,temp.size()));//sublist包括后一个参数作为下标所对应的内容
            else
                ll.addAll(temp);
        }
        if(follows.containsKey(userId))
        {
            Iterator<Integer> it=follows.get(userId).iterator();
            while(it.hasNext()){//得到的是用户关注的人
                int followee=it.next();
                if(tweets.containsKey(followee))
                {
                    List temp=tweets.get(followee);
                    if(temp.size()>feedNum)
                        ll.addAll(temp.subList(temp.size()-feedNum,temp.size()));
                    else
                        ll.addAll(temp);
                }
            }
        }
        ll=removeRepeatTweet(ll);//去重.使用hashset会影响顺序
        sortTweet(ll);
        int oldIndex;//返回的最早推特的序号，
        if(ll.size()<feedNum)
            oldIndex=0;
        else
            oldIndex=ll.size()-feedNum;
        List<Integer> result=new LinkedList<Integer>();
        for(int i=ll.size()-1;i>=oldIndex;i--)//可以用Collections.reverse(list)实现列表翻转。此处ll列表与result的对象不同
            result.add(ll.get(i).tweetID);
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!follows.containsKey(followerId))
        {
            HashSet<Integer> hs=new HashSet<Integer>();
            follows.put(followerId,hs);
        }
        follows.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!follows.containsKey(followerId))
        {
            return;
        }
        follows.get(followerId).remove(followeeId);
    }

    public static void main(String[] args){
        L355_DesignTwitter twitter = new L355_DesignTwitter();

        /*twitter.postTweet(1, 1);
        twitter.getNewsFeed(1);
        twitter.follow(2, 1);
        twitter.getNewsFeed(2);
        twitter.unfollow(2, 1);
        twitter.getNewsFeed(2);*/

        /*
        twitter.postTweet(1,5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1,2);
        System.out.println(twitter.getNewsFeed(1));*/

       /* twitter.postTweet(1,5);
        twitter.follow(1,1);
        System.out.println(twitter.getNewsFeed(1));*/


        twitter.postTweet(1,5);
        twitter.postTweet(1,3);
        twitter.postTweet(1,101);
        twitter.postTweet(1,13);
        twitter.postTweet(1,10);
        twitter.postTweet(1,2);
        twitter.postTweet(1,94);
        twitter.postTweet(1,505);
        twitter.postTweet(1,333);
        twitter.postTweet(1,22);
        twitter.postTweet(1,11);
        System.out.println(twitter.getNewsFeed(1));
    }
/*    public static void main(String [] args) throws IOException {
        System.out.print("Enter Operations:");
        String operationStr=System.in.toString();
        String[] opers=operationStr.split(",");
        System.out.print("Enter args:");
        String argsStr=System.in.toString();
        String[] arg=argsStr.split(",");
    }*/
}
