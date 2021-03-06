(ns project-euler.p35
      (:require
             [project-euler.primes  :as primes]
             [project-euler.utils  :as utils]
     )

)


;Circular primes
;Problem 35
;The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

;There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

;How many circular primes are there below one million?




(defn rot [n]
  (read-string
    (apply str
      (let [s0 (vec (str n))]
        (cons (peek s0) (pop s0))
      ))))

(defn pre-check [n]
  (if (< n 10) true
   (not
    (some #{0 2 4 5 6 8} (utils/digits n)))))

(defn circular-prime? [n]
 (when (pre-check n)
  (every? identity
   (map primes/prime?
     (rest
        (take    (count (str n))   (iterate rot n))
         )))))

(time
  (println
   (count
    (filter circular-prime? (primes/primes3 1000000)))))

