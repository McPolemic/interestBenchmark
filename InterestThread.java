public class InterestThread implements Runnable {
    public void run() {
        // 1,000,000,000; i++)
        for (int i = 0; i < 1000000000; i++)
            monthlyInterest(50000, 0.03, 30);
    }

    public static double monthlyInterest(double balance, double apr, int days) {
        double dailyRate = apr/365;
        double totalInterest = 0;
        double interest;

        for (int i = 0; i < days; i++) {
            interest = balance * dailyRate;
            totalInterest += interest;
            balance += interest;
        }

        return totalInterest;
    }

    public static void main(String args[]) {
        long start = System.currentTimeMillis();
        // 1,000,000,000
        for (int i = 0; i < 10000; i++)
            (new Thread(new InterestThread())).start();
        long end = System.currentTimeMillis();
        System.out.println(String.format("%.3f seconds", (float) (end-start)/1000));
    }
}
