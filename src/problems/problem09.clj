
(ns problems.problem9
  (:require [clojure.string :as str]
            [utils.maths :as maths])
  )


(def solution
 (str/join ["The sum of all prime numbers below 2000000: "
           (->>
            (for [i (range 0 2000000) :when (maths/is-prime i)] i)
            (reduce +)
            str)
            "."]
 )
  )
