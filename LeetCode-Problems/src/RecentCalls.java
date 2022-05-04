import java.util.LinkedList;

public class RecentCalls {
    LinkedList<Integer> timeStamps;
    // So, when I was assuming that you declared timestamps as Deque<Integer>,
    // the problem would have been that the Deque interface doesn't have a remove method that takes in an index;
    // it only has a remove method that takes in an object to search for and remove.
    // In that case, your code would've looped infinitely

    public static void main(String[] args) {

        RecentCalls obj = new RecentCalls();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }

    public RecentCalls() {
        timeStamps = new LinkedList<>();

    }

    //You know the current time
    //You have a record of all the previous timestamps that were
    //within the window the last time the ping method was called

    public int ping(int t) {

        timeStamps.add(t);
        //[t - 3000, t]

//        if (t - 3000 < timeStamps.get()) {
//            timeStamps.remove(); // double check this
//        }

        //!!!!Line 24 ensures the list will never be empty!!!!
        while (timeStamps.get(0) < t - 3000) {
            timeStamps.remove(0);
        };
        return timeStamps.size();
    }
}
