(ns interest.core
    (:gen-class :main true))

(defn daily-interest [start apr]
    (* start (/ apr 365)))

(defn monthly-interest [start apr days]
    (loop [balance start
           days days
           interest (daily-interest balance apr)
           acc []]
        (if (= days 0)
            acc
            (recur (+ balance interest)
                   (dec days)
                   (daily-interest balance apr)
                   (conj acc interest)))))

(defn sum [& x] (reduce + x))

(defn -main [& args]
    (time
        (dotimes [_ 100000]
            (sum (monthly-interest 50000 0.03 30)))))
