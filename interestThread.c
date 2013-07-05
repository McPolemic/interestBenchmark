#include <pthread.h>
#define NUM_THREADS    10
#define NUM_ITERS      1000000

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

void work() {
    int i;
    for (i = 0; i < NUM_ITERS; i++)
        monthlyInterest(50000, 0.03, 30);
}

void *runInterest(void *ignore)
{
    work();
    pthread_exit(NULL);
}

int main(int argc, char *argv[])
{
    pthread_t threads[NUM_THREADS];
    long t;

    for (t = 0; t < NUM_THREADS; t++)
        pthread_create(&threads[t], NULL, work, (void *)NULL);

    pthread_exit(NULL);
    return 0;
}
