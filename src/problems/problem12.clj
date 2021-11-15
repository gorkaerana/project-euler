
(ns problems.problem12
  (:require [utils.maths :as maths])
  )

(defn next-triangular-number [[n t]]
  (if (= n 1)
    [2 3]
    [(inc n) (* (/ (inc n) (dec n)) t)]
    )
  )

(def triangular-numbers (iterate next-triangular-number [2 3]))

(def solution
  (let [n-divisors (atom 0)
        i (atom 0)
        tri (atom 0)]
    (while (<= @n-divisors 500)
      (do
        (swap! tri #(last (next-triangular-number [@i %1])))
        (swap! n-divisors #(+ (* 0 %1) (count (maths/divisors @tri))))
        (swap! i inc)
        (when (== (mod @i 1000) 0) (println @i))
        )
      )
    @tri
    )
  )
