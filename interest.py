# -*- coding: utf-8 -*-

def monthly_interest(starting_balance, rate, days=30):
	total_interest = 0
	daily_rate = rate/365
	balance = starting_balance
	
	for i in range(days):
		interest = balance * daily_rate
		total_interest += interest
		balance += interest
	
	return total_interest

if __name__ == '__main__':
    for i in range(100000):
        monthly_interest(50000, 0.03)
