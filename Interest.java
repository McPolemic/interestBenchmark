public class Interest {
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
        for (long i = 0; i < 1000000000L; i++)
            monthlyInterest(50000, 0.03, 30);
        long end = System.currentTimeMillis();
        System.out.println(String.format("%.3f seconds", (float) (end-start)/1000));
    }
}
