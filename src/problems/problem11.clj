
(ns problems.problem11
  (:require [utils.io :as uio]
            [clojure.string :as str]
            [incanter.core :refer :all])
  )

(def input-data-path "resources/problem10_grid.txt")

(defn seq-to-int [seq]
  (map #(Integer. %) seq)
  )

(defn windows
  "Retrieves from 'seq' all sliding windows of size 'size'.
  E.g.: (window (range 3) 2) --> ((0 1) (1 2))"
  [seq size]
  (let [length (count seq)]
    (for [i (reverse (range size (inc length)))]
      (take size (take-last i seq))
      )
    )
  )

(def data-matrix
  (->>
   (uio/read-lines input-data-path)
   (map #(str/split %1 #" "))
   (map seq-to-int)
   matrix
   )
  )

;; Up-down
(sel data-matrix :rows (range 4) :cols 0)
;; Left-right
(sel data-matrix :rows 0 :cols (range 4))
;; Diagonal
(diag (sel data-matrix :rows 0 :cols (range 4)))

