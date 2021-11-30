
(ns problems.problem13
  (:require [utils.io :as io])
  (:require [clojure.edn :as edn])
  )

(def solution
  (->
   (->>
    (io/read-lines "./resources/problem13_numbers.txt")
    (map edn/read-string)
    (reduce +)
    biginteger
    (format "%d")
    )
   (subs 0 10)
   )
)
