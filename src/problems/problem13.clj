
(ns problems.problem13
  (:require [utils.io :as io])
  (:require [clojure.edn :as edn])
  )

(defn pretty-solution [n]
  (format
   "The first ten digits of the sum are '%s'"
   (subs (format "%d" n) 0 10)
   )
  )

(def solution
  (->>
   (io/read-lines "./resources/problem13_numbers.txt")
   (map edn/read-string)
   (reduce +)
   biginteger
   pretty-solution
   )
)
