package OldHomeWork;
import java.util. concurrent.*;

public class Sum {
    public static void main(String[] args) {
        final int N = 9000000;
        double[] list = new double[N];
        for (int i = 0; i < list.length; i++)
            list[i] = i;
        long startTime = System.currentTimeMillis();

        System.out.println("The Sum number is " + sum(list));
        long endTime = System.currentTimeMillis();
        System.out.println("The number of processors is " +
                Runtime.getRuntime().availableProcessors());
        System.out.println("Time is " + (endTime - startTime) + " milliseconds");
    }

    public static double sum(double[] list) {

        RecursiveTask<Integer> task = new SumTask(0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class SumTask extends RecursiveTask<Integer> {
        private final static int THRESHOLD = 1000;

        private int low;
        private int high;

        public SumTask(int low, int high) {

            this.low = low;
            this.high = high;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            if (high - low <= THRESHOLD) {
                for (int i = low; i <= high; i++)
                    sum += i;
            } else {
                int mid = low + (high - low) / 2;
                SumTask lt = new SumTask(low, mid);
                SumTask rt = new SumTask(mid + 1, high);
                lt.fork();
                rt.fork();
                int leftsum = lt.join();
                int rightsum = rt.join();
                sum = leftsum + rightsum;
            }
            return sum;
        }
    }
}
