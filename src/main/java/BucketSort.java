import java.util.ArrayList;

public class BucketSort {
    public static int[] bucketSort(int[] array, int numOfBuckets, int min, int max) {
        ArrayList<Integer>[] buckets = new ArrayList[numOfBuckets];
        int range = max - min;
        //int numOfIterations = 0;
        for (int i = 0; i < array.length; ++i) {
            //numOfIterations++;
            int index = (min < 0 ? (array[i] - min) * (numOfBuckets-1) :
                    array[i] * (numOfBuckets-1)) / range;
            if (buckets[index] == null)
                buckets[index] = new ArrayList<>();
            buckets[index].add(array[i]);
        }
        for (int i = 0; i < numOfBuckets; ++i) {
            if (buckets[i] == null)
                buckets[i] = new ArrayList<>();
            // insertion sort
            for (int j = 1; j < buckets[i].size(); ++j) {
                int key = buckets[i].get(j);
                int k = j - 1;

                while (k >= 0 && buckets[i].get(k) > key) {
                    buckets[i].set(k + 1, buckets[i].get(k));
                    k--;
                    //numOfIterations++;
                }
                buckets[i].set(k + 1, key);
            }
        }
        int[] ans = new int[array.length];
        int k = 0;
        for (int i = 0; i < buckets.length; ++i) {
            for (int j = 0; j < buckets[i].size(); ++j) {
                ans[k] = buckets[i].get(j);
                k++;
            }
        }
        //System.out.println(numOfIterations); // Считаем кол-во итераций
        return ans;
    }

    public static int[] bucketSort(int[] array, int numsOfBucket) {
        int mn = (int)1e9;
        int mx = -(int)1e9;
        for (int i = 0; i < array.length;++i) {
            mn = Math.min(mn,array[i]);
            mx = Math.max(mx,array[i]);
        }
        return bucketSort(array, numsOfBucket, mn, mx);
    }
}
