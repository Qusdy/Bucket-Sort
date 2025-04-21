import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        for (int i = 1; i <= 100; ++i) {
            try {
                Scanner sc = new Scanner(new File(i + ".txt"));
                int n = sc.nextInt();
                int[] p = new int[n];
                for (int j = 0; j < n; ++j) {
                    p[j] = sc.nextInt();
                }
                long start = System.nanoTime(); // Тут измеряем время
                BucketSort.bucketSort(p, n);
                BucketSort.bucketSort(p, n);
                BucketSort.bucketSort(p, n);
                long end = System.nanoTime();
                System.out.println(n + "\t" + (end-start)/3); // Берем три раза запускаем и ищем среднее время
//                System.out.print(n + "\t"); // количество итераций
//                BucketSort.bucketSort(p, n);
            } catch (IOException ioException) {
                break;
            }
        }
    }

    public static int[] generateTest(int size) {
        Random random = new Random();
        int[] ans = new int[size];
        for (int i = 0; i < size; ++i) {
            ans[i] = random.nextInt(-(int)1e5, (int)1e5);
        }
        return ans;
    }

    public static void generateFiles() {
        for (int i = 100; i <= 10000; i += 100) {
            int[] p = generateTest(i);
            try (FileWriter writer = new FileWriter(i/100 + ".txt", false)) {
                String s = "";
                s += i + "\n";
                for (int j = 0; j < i; ++j) {
                    s += p[j] + "\n";
                }
                writer.write(s);
            } catch (IOException ioException) {
                break;
            }
        }
    }
}
