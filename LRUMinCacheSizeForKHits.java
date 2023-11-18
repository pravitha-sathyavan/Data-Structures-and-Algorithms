import java.util.*;

public class A2 {

    // Function to count hits for a given cache size
    private static int countHits(int cacheSize, List<String> items, int k) {
        LinkedList<String> cache = new LinkedList<>();
        int hits = 0;

        for (String item : items) {
            if (cache.remove(item)) {
                cache.addFirst(item); // Move the accessed item to the front to mark it as most recently used
                hits++;
            } else {
                if (cache.size() >= cacheSize) {
                    cache.removeLast(); // Remove the least recently used item (last item in the list)
                }
                cache.addFirst(item); // Add the item to the front of the cache
            }
        }
        return hits;
    }

    // Function to find the minimum cache size for k hits
    private static int minCacheSizeForKHits(List<String> items, int k) {
        long uniqueItems = items.stream().distinct().count();
        if (k > items.size()) {
            return -1; // Not possible to have k hits if k is greater than the total requests
        }

        // Binary search for the minimum cache size
        int left = 1, right = (int) uniqueItems;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hits = countHits(mid, items, k);

            if (hits >= k) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        List<String> requests =  Arrays.asList(
//                "item2", "item4", "item2", "item3", "item3", "item6", "item3", "item5", "item2", "item6",
//                "item5", "item2", "item4", "item6", "item4", "item2", "item10", "item3", "item8", "item5",
//                "item9", "item10", "item2", "item2", "item5", "item5", "item4", "item7", "item6", "item4",
//                "item5", "item8", "item6", "item3", "item9", "item2", "item2", "item5", "item8", "item8",
//                "item3", "item7", "item5", "item7", "item8", "item2", "item3", "item10", "item6", "item10",
//                "item8", "item6", "item4", "item5", "item2", "item8", "item3", "item2", "item2", "item9",
//                "item4", "item9", "item2", "item10", "item3", "item2", "item4", "item3", "item1", "item5",
//                "item4", "item8", "item3", "item9", "item9", "item8", "item10", "item6", "item1", "item7",
//                "item6", "item5", "item1", "item7", "item8", "item9", "item1", "item9", "item7", "item5",
//                "item9", "item2", "item6", "item10", "item9", "item7", "item6", "item5", "item7", "item7"
//        );
//
//        int k = 70; // Desired minimum hits
//
//        int minimumCacheSize = minCacheSizeForKHits(requests, k);
//        System.out.println("Minimum cache size required for at least " + k + " hits: " + minimumCacheSize);

        List<String> requests =  Arrays.asList(
                "item2", "item3", "item2", "item4", "item4"
        );

        int k = 1; // Desired minimum hits

        int minimumCacheSize = minCacheSizeForKHits(requests, k);
        System.out.println("Minimum cache size required for at least " + k + " hits: " + minimumCacheSize);
    }
}

/*Set up the binary search range for the cache size between 1 and the total number of unique items in the given list.
For each cache size in the binary search range, simulate the cache behavior using LRU replacement policy and count the number of hits.
Update the binary search range based on whether the count of hits is greater than or equal to k.
Continue the binary search until the minimum cache size that satisfies k hits is found or the search range is exhausted.
*/

