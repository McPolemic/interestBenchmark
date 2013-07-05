# -*- coding: utf-8 -*-

def monthly_interest(starting_balance, rate, days=30):
	total_interest = 0
	daily_rate = rate/365
	balance = starting_balance
	
	for i in range(days):
		interest = balance * daily_rate
        yield interest

def total_interest(balance, rate, days=30):
    return sum(monthly_interest(balance, rate, days))

if __name__ == '__main__':
    for i in range(100000):
        total_interest(50000, 0.03)
