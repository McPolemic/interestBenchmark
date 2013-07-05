package main

import "runtime"

func Interest(start float64, rate float64, days int) (total float64) {
	balance := start
	daily_rate := rate / 365
	for i := 0; i < days; i++ {
		interest := balance * daily_rate
		total += interest
		balance += interest
	}

	return total
}
func main() {
	for i := 0; i < 10000; i++ {
        go func(){
            for j := 0; j < 10000000; j++ {
                Interest(50000, 0.03, 30)
            }
        }()
    }
    runtime.Gosched()
}
