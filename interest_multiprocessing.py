# -*- coding: utf-8 -*-
import multiprocessing

def monthly_interest(starting_balance, rate, days=30):
	total_interest = 0
	daily_rate = rate/365
	balance = starting_balance
	
	for i in range(days):
		interest = balance * daily_rate
        yield interest

def total_interest(balance, rate, days=30):
    return sum(monthly_interest(balance, rate, days))

def worker(balance, rate):
    [total_interest(balance, rate) for i in range(100000)]

if __name__ == '__main__':
    processes = 4
    procs = []
    
    for i in range(processes):
        p = multiprocessing.Process(target=worker, args=(50000, 0.03))
        procs.append(p)
        p.start()

    #Wait to finish
    for p in procs:
        p.join()
