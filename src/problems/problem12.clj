
(ns problems.problem12
  (:require [utils.maths :as maths])
  )

(defn triangular-number
  ;; Returns the n-th triangular number
  [n]
  (/ (* n (inc n)) 2)
  )

(def solution
  (let [n-divisors (atom 0)
        i (atom 0)
        tri (atom 0)]
    (while (<= @n-divisors 500)
      (do
        (swap! tri #(+ (* 0 %1) (triangular-number @i)))
        (swap! n-divisors #(+ (* 0 %1) (count (maths/divisors @tri))))
        (swap! i inc)
        (when (== (mod @i 1000) 0) (println @i))
        )
      )
    (println (str @tri))
    )
  )
