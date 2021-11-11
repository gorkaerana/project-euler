
(ns problems.problem8
  (:require [clojure.string :as str])
  )


(defn cond1 [a b c]
  (== (+ (Math/pow a 2) (Math/pow b 2) (- (Math/pow c 2))) 0)
  )

(defn cond2 [a b c]
  (== (+ a b c) 1000)
  )

(def solution
  (let [s (atom "")]
    (for [a (range 1001)
            b (range (inc a) 1001)
            c (range (inc b) 1001)
            :when (and (cond1 a b c) (cond2 a b c))]
      (str/join ["The product of "
                 a
                 ", "
                 b
                 ", and "
                 c
                 ": "
                 (* a b c)
                 "."])
      )
    )
)
