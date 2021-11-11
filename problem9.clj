
(require '[clojure.string :as str])


(defn is-prime
  "Sieve of Erasthotenes with 6k+-1 optimization.
  Source: https://en.wikipedia.org/wiki/Primality_test#Python"
  [n]
  (if (<= n 3)
    (> n 1)
    (if (or (= (mod n 3) 0) (= (mod n 2) 0))
      false
      (if (->>
           (for [i (range 5 (inc (Math/sqrt n)) 6)
                 :when (or (= (mod n i) 0) (= (mod n (+ i 2)) 0))]
             i)
           (some identity))
        false
        true
        ))))

(println
 (str/join ["The sum of all prime numbers below 2000000: "
           (->>
            (for [i (range 0 2000000) :when (is-prime i)] i)
            (reduce +)
            str)
            "."]
 )
)
