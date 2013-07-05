double monthlyInterest(float balance, float rate, int days)
{
    int i;
    double interest;
    double totalInterest = 0;
    double dailyRate = rate/365;

    for (i = 0; i < days; i++) {
        interest = balance * dailyRate;
        totalInterest += interest;
        balance += interest;
    }

    return totalInterest;
}

int main(int argc, char *argv[])
{
    int i;
    int niters = 4000000;

    for (i = 0; i < niters; i++)
        monthlyInterest(50000, 0.03, 30);

    return 0;
}
